import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.print("접속할 서버의 IP를 입력하세요.\n→ ");

        String serverIP = new Scanner(System.in).nextLine(), line = null;

        try (Socket cs = new Socket(serverIP, 9000)){
            BufferedReader br = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while ((line = br.readLine()) != null) System.out.println(line);
        }
        catch (UnknownHostException e) {System.out.println("입력된 주소를 찾지 못했습니다.");}
        catch (SocketException e) {System.out.println("서버와의 연결이 끊어졌습니다.");}
        catch (Exception e) {System.out.println("알 수 없는 에러가 발생하였습니다.");}
    }
}
