// 3.
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// ① Member 클래스 정의
class Member {
    String name;
    Gender gender;
    int age;

    // 파이프라인을 만들기 위해 자기 자신을 리턴한다.
    public Member setName(String name) {
        this.name = name;
        return this;
    }

    public Member setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Member setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Member(){}

    @Override
    public String toString() {
        return "Member(" +
                name + ", " +
                gender + ", " +
                age + ')';
    }
}

public class Problem3 {
    // ② 정적 정수 필드 정의
    static int idx = 0;
    public static void main(String[] args){

        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");
        List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);  // List.of 함수는 wrapper 클래스들의 리스트를 리턴한다.
        List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

        // ③ 매핑
        Stream<Member> mapped = names.stream().map(
            name -> new Member().setName(name)
                                .setAge(ages.get(idx))
                                .setGender(genders.get(idx++))
        );

        // ④ 출력
        // (객체 생성을 ③과 같은 코드로 다시 하면 불필요한 코드와 메모리를 다시 쓰게 되므로 peek 을 사용한다.)
        System.out.println("[Member 스트림 원소]");
        Stream<Member> copied = mapped.peek(member -> System.out.print(member.toString() + ' '));

        // peek 는 lazy operation 이므로 위의 코드에서는 전혀 실행되지 않는다.
        // println 보다 안에 있는 copied.collect 가 먼저 수행되고, mapped.peek 연산도 이 때 수행되는데,
        // peek 연산은 print 를 포함하므로 먼저 print 되고, collect 의 결과물은 나중의 println 에 담겨 나온다.
        System.out.println("\n\n[Member 스트림을 성별로 그룹핑]\n"
                +copied.collect(Collectors.groupingBy(Member::getGender)));
    }
}
