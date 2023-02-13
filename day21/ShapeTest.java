import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 도전 과제 01 ~ 03번은 번호 순서대로 버전 업 되는 방식입니다.<br>
 * 따라서 여러 파일을 쓰지 않고, 각 문제에 대한 답을 별도의 버전으로 commit 하였습니다.<p>
 * 현재 버전은 <b>3번 문제</b>에 대한 답입니다.
 */
public class ShapeTest {
    static List<Shape> findShapes(List<Shape> shapes, Predicate<Shape> p) {
        ArrayList<Shape> ret = new ArrayList<>();

        for (Shape s : shapes) if (p.test(s)) ret.add(s);
        return ret;
    }

}
