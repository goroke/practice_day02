// 2.
import java.util.List;

// ① Gender 타입 정의
enum Gender { 남, 여 }

public class Problem2 {
    public static void main(String[] args){
        // ② 변수 선언
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");
        List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);  // List.of 함수는 wrapper 클래스들의 리스트를 리턴한다.
        List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

        // ③ 계산
        System.out.println(
                ages.stream().reduce(0, Integer::sum)
        );

        System.out.println(
                ages.stream().reduce(0, Integer::max)
        );

        System.out.println(

                ages.stream().mapToDouble(x -> (double) x / ages.size())
                        .reduce(Double::sum)
                        .getAsDouble()  // Optional 이 리턴되므로 getAsDouble 메서드를 써야 한다.
        );
    }
}
