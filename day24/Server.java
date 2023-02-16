import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(9000)){
            System.out.println("클라이언트의 접속을 기다립니다...");
            Socket cs = ss.accept();
            System.out.println("클라이언트(" + cs.getRemoteSocketAddress() + ")의 접속 요청을 수락합니다.");
            PrintWriter pw = new PrintWriter(cs.getOutputStream(), true);

            pw.println(new Date());
            System.out.println("클라이언트에게 날짜/시간 데이터를 전송하였습니다.");
        }
        catch (Exception e) {
            System.out.println("에러가 발생하였습니다.");
        }
    }
}
