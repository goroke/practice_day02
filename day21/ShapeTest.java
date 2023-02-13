import java.util.ArrayList;
import java.util.List;

/**
 * 도전 과제 01 ~ 03번은 번호 순서대로 버전 업 되는 방식입니다.<br>
 * 따라서 여러 파일을 쓰지 않고, 각 문제에 대한 답을 별도의 버전으로 commit 하였습니다.<p>
 * 현재 버전은 <b>2번 문제</b>에 대한 답입니다.
 */
public class ShapeTest {
    /**
     * 주어진 조건을 만족하는 도형들을 출력합니다.<br>
     * <i>null</i> 이 들어가는 조건은 비교하지 않습니다.
     */
    static List<Shape> findShapes(List<Shape> shapes, String type, String color, double area) {
        ArrayList<Shape> ret = new ArrayList<>();
        boolean match;

        for (Shape s : shapes) {
            match = true;
            if (type != null) match = match && s.getType().equals(type);
            if (color != null) match = match && s.getColor().equals(color);
            if (area > 0.) match = match && s.getArea() <= area;

            if (match) ret.add(s);
        }
        return ret;
    }

}
