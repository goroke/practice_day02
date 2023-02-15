// 1.
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Problem1 {
    public static void main(String[] args) {
        Consumer<String> print = s -> System.out.print(s + " ");

        // ① names 객체 생성
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");

        // ② names 를 스트림으로 만든 후, 정렬 없이 '이' 씨보다 앞에 있는 사람의 이름 출력
        names.stream().filter(name -> name.compareTo("이") < 0).forEach(print);
        System.out.println();

        // ③ names 를 스트림으로 만들고 정렬한 후 출력
        names.stream().sorted().forEach(print);
        System.out.println();

        // ④ names 를 스트림으로 만든 후 첫 번째 원소 출력
        Optional<String> first = names.stream().findFirst();
        System.out.println(first);        // findFirst 의 리턴 값은 Optional 이므로
        System.out.println(first.get());  // get() 메서드를 써야 실제 값이 나온다.

        // ⑤ 원소의 개수출력
        System.out.println(names.stream().count());


        // System.out.println("\""+new Scanner(System.in).nextLine().replace(" ", "\", \"")+"\"");
    }


}
