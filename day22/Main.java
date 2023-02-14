import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 이 버전은 문제 3번에 대한 답입니다.<br>
 * 다른 문제들에 대한 답은 다른 버전으로 commit 하였습니다.
 */
public class Main {
    public static void main(String[] args) {
        int alphabet = 'a';

        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable task = () -> {
            for (int i = 0; i <= 4; ++i) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            exec.shutdown();
        };

        exec.execute(task);

        for(; alphabet <= 'z' && !exec.isShutdown(); alphabet++) {
            System.out.println((char) alphabet);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
