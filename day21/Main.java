/**
 * 도전 과제 01 ~ 03번은 번호 순서대로 버전 업 되는 방식입니다.<br>
 * 따라서 여러 파일을 쓰지 않고, 각 문제에 대한 답을 별도의 버전으로 commit 하였습니다.<p>
 * 현재 버전은 <b>2번 문제</b>에 대한 답입니다.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("사각형 : "
                + ShapeTest.findShapes(Shape.shapes, "사각형", null, 0.));

        System.out.println("빨간 도형(면적<=12.0) : "
                + ShapeTest.findShapes(Shape.shapes, null, "빨간색", 12.0));
    }
}
