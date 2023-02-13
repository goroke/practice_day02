import java.util.ArrayList;
import java.util.List;

/**
 * 도전 과제 01 ~ 03번은 번호 순서대로 버전 업 되는 방식입니다.<br>
 * 따라서 여러 파일을 쓰지 않고, 각 문제에 대한 답을 별도의 버전으로 commit 하였습니다.<p>
 * 현재 버전은 <b>1번 문제</b>에 대한 답입니다.
 */
public class ShapeTest {
    static List<Shape> findShapesByType(List<Shape> shapes, String type){
        ArrayList<Shape> ret = new ArrayList<>();
        for(Shape s : shapes)
            if(s.getType().equals(type)) ret.add(s);
        return ret;
    }

    static List<Shape> findShapesByColorNArea(List<Shape> shapes, String color, double area){
        ArrayList<Shape> ret = new ArrayList<>();
        for(Shape s : shapes)
            if(s.getColor().equals(color) && s.getArea() <= area) ret.add(s);
        return ret;
    }
}
