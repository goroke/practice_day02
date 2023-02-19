import org.json.JSONObject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiServer implements Runnable {
    private Socket clientSocket = null;
    DataInputStream dis; DataOutputStream dos;
    public MultiServer(Socket clientSocket, List<Product> data) throws IOException {
        this.clientSocket = clientSocket;
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run() {
        System.out.println(clientSocket.getRemoteSocketAddress() + " 에서 서버에 접속하였습니다.");

        // 연결되자마자 목록을 보낸다.
        try {dos.writeUTF(new JSONObject()
                .put("result", "success")
                .put("data", ProductServer.getData())
                .toString());}
        catch (IOException e) {throw new RuntimeException(e);}

        // 연결되어 있다면 요청을 계속 처리한다.
        while (!clientSocket.isClosed()) {
            try {
                // 데이터를 받아온 후 처리한다.
                JSONObject receivedPacket = new JSONObject(dis.readUTF());

                String result = switch (receivedPacket.getInt("menu")) {
                    case 1 -> {
                        System.out.printf("%s 에서 재고 %d개의 상품(%s, %d원) 추가를 요청하였습니다.\n",
                                clientSocket.getRemoteSocketAddress().toString(),
                                receivedPacket.getJSONObject("data").getInt("stock"),
                                receivedPacket.getJSONObject("data").getString("name"),
                                receivedPacket.getJSONObject("data").getInt("price")
                        );
                        yield ProductServer.addData(
                            receivedPacket.getJSONObject("data").getString("name"),
                            receivedPacket.getJSONObject("data").getInt("price"),
                            receivedPacket.getJSONObject("data").getInt("stock")
                    );}
                    case 2 -> {
                        System.out.printf("%s 에서 상품 정보 수정을 요청하였습니다.\n",
                                clientSocket.getRemoteSocketAddress().toString()
                        );
                        yield ProductServer.modifyData(
                            receivedPacket.getJSONObject("data").getInt("no"),
                            receivedPacket.getJSONObject("data").getString("name"),
                            receivedPacket.getJSONObject("data").getInt("price"),
                            receivedPacket.getJSONObject("data").getInt("stock")
                    );}
                    case 3 -> {
                        System.out.printf("%s 에서 상품 삭제를 요청하였습니다.\n",
                                clientSocket.getRemoteSocketAddress().toString()
                        );
                        yield ProductServer.deleteData(
                            receivedPacket.getJSONObject("data").getInt("no")
                    );}
                    default -> throw new RuntimeException();
                };

                // 결과물을 보낸다.
                dos.writeUTF(new JSONObject()
                        .put("result", result)
                        .put("data", ProductServer.getData())
                        .toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

public class ProductServer {
    public static final int port = 20000;
    private static final ServerSocket serverSocket; // 문제 생기면 MultiServer 에 만들어 놓을 것
    private static final List<Product> data = new ArrayList<>();

    static {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Product> getData() {
        return data;
    }

    public static String addData(String name, int price, int stock) {
        Product prod = new Product();
        prod.setNo(data.size() + 1);
        prod.setName(name);
        prod.setPrice(price);
        prod.setStock(stock);
        data.add(prod);
        return "success";
    }

    public static String modifyData(int no, String name, int price, int stock) {
        if (no < 1 || no > data.size()) {
            return "fail";
        } else {
            Product prod = data.get(no - 1);
            prod.setName(name);
            prod.setPrice(price);
            prod.setStock(stock);
            return "success";
        }
    }

    public static String deleteData(int no) {
        if (no < 1 || no > data.size()) {
            return "fail";
        } else {
            data.remove(no - 1);

            // 밀린 번호를 처리한다.
            for (int idx = no-1; idx < data.size(); idx++) data.get(idx).setNo(idx+1);
            return "success";
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(30);
        System.out.println("상품 관리 서버를 실행합니다.");

        // 클라이언트 받기
        new Thread(() -> {
            while (true) {
                try {
                    pool.submit(new MultiServer(serverSocket.accept(), data));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}

