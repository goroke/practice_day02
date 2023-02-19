import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import org.json.JSONObject;

public class ProductClient {
    public static final String hostName = "127.0.0.1";
    public static final int port = 20000;

    private static final Scanner sc = new Scanner(System.in);

    // 소켓과 입출력 버퍼 설정
    private static final Socket clientSocket = new Socket();
    private static final DataOutputStream dos;
    private static final DataInputStream dis;
    static {
        try {
            clientSocket.connect(new InetSocketAddress(hostName, port));
            dos = new DataOutputStream(clientSocket.getOutputStream());
            dis = new DataInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // 명령 리스트(새로 추가될 것을 고려하여 만들어 본 것)
    private static final String[] commandNames = {"Create", "Update", "Delete", "Exit"};
    private static final HashMap<String, Runnable> commands = new HashMap<>();
    static {
        commands.put("Create", ProductClient::create);
        commands.put("Update", ProductClient::update);
        commands.put("Delete", ProductClient::delete);
        commands.put("Exit"  , () -> {endOfProgram = true;});
    }

    // 상품 목록을 가져오고 출력한다.
    public static void getProductFromServer() {
        JSONObject packet = null;
        try {
            // 처음에는 서버 단에서 알아서 정보를 보내주고, 이후에는 이 메서드가 실행되기 전에 요청을 보낸다.
            packet = new JSONObject(dis.readUTF());
        } catch (IOException e) {
            endOfProgram = true;
            System.out.println("데이터를 받지 못했습니다.");
            return;
        }

        // 출력 부분
        if (Objects.equals(packet.getString("result"), "success")) {
            System.out.println("[상품 목록]");
            System.out.println("----------------------------------------------------------------------");
            System.out.printf ("%4s %-40s%15s%10s\n", "no", "name", "price", "stock");
            System.out.println("----------------------------------------------------------------------");

            packet.getJSONArray("data").forEach(o -> {
                JSONObject data = (JSONObject) o;
                System.out.printf ("%4d %-40s%15d%10d\n",
                        data.getInt("no"),
                        data.getString("name"),
                        data.getInt("price"),
                        data.getInt("stock")
                );
            });
        }
        else {
            System.out.println("잘못된 요청입니다. 프로그램을 종료합니다.");
            endOfProgram = true;
            return;
        }

        System.out.println("----------------------------------------------------------------------");
    }

    // 메뉴
    public static void query() {
        int cnt = 0;

        getProductFromServer();
        if (endOfProgram) return;

        System.out.print("메뉴: ");
        for(String command : commandNames){
            if(cnt > 0) System.out.print(" | ");
            System.out.printf("%d.%s", ++cnt, command);
        }
        System.out.print("\n선택: ");

        int idx = sc.nextInt() - 1; sc.nextLine();
        commands.get(commandNames[idx]).run();
    }

    // 여러 가지 명령문
    public static void create() {
        JSONObject packet = new JSONObject();

        String name = null;
        int price = 0, stock = 0;

        System.out.println("[상품 목록]");
        System.out.print  ("상품 이름: "); name  = sc.nextLine();
        System.out.print  ("상품 가격: "); price = sc.nextInt ();
        System.out.print  ("상품 재고: "); stock = sc.nextInt (); sc.nextLine();

        packet.put("menu", 1);
        packet.put("data", new JSONObject()
                                .put("name" , name )
                                .put("price", price)
                                .put("stock", stock)
        );

        try {
            dos.writeUTF(packet.toString());
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update() {
        JSONObject packet = new JSONObject();

        String name = null;
        int no = 0, price = 0, stock = 0;

        System.out.println("[상품 수정]");
        System.out.print  ("상품 번호: "); no    = sc.nextInt (); sc.nextLine();
        System.out.print  ("이름 변경: "); name  = sc.nextLine();
        System.out.print  ("가격 변경: "); price = sc.nextInt ();
        System.out.print  ("재고 변경: "); stock = sc.nextInt (); sc.nextLine();

        packet.put("menu", 2);
        packet.put("data", new JSONObject()
                .put("no"   , no   )
                .put("name" , name )
                .put("price", price)
                .put("stock", stock)
        );
        try {
            dos.writeUTF(packet.toString());
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(){
        JSONObject packet = new JSONObject();
        int no = 0;

        System.out.println("[상품 삭제]");
        System.out.print  ("상품 번호: "); no = sc.nextInt(); sc.nextLine();

        packet.put("menu", 3);
        packet.put("data", new JSONObject().put("no", no));

        try {
            dos.writeUTF(packet.toString());
            dos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean endOfProgram = false;

    public static void main(String[] args) throws IOException {
        while (!endOfProgram) query();
    }
}
