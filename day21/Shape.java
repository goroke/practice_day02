import java.util.ArrayList;

/**
 * 도전 과제 01 ~ 03번은 번호 순서대로 버전 업 되는 방식입니다.<br>
 * 따라서 여러 파일을 쓰지 않고, 각 문제에 대한 답을 별도의 버전으로 commit 하였습니다.<p>
 * 현재 파일은 변경 사항이 없으므로 1~3번 문제에서 공통으로 사용됩니다.
 */
class Shape {
    private String type;    // 도형의 종류
    private String color;   // 도형의 색깔
    private Double area;    // 도형의 면적

    public static ArrayList<Shape> shapes = new ArrayList<>(){{
        add(new Shape("삼각형", "빨간색", 10.5));
        add(new Shape("사각형", "파란색", 11.2));
        add(new Shape("원", "파란색", 16.5));
        add(new Shape("원", "빨간색", 5.3));
        add(new Shape("원", "노란색", 8.1));
        add(new Shape("사각형", "파란색", 20.7));
        add(new Shape("삼각형", "파란색", 3.4));
        add(new Shape("사각형", "빨간색", 12.6));
    }};  // Double Brace Initialization 방식으로 초기화

    public Shape(String type, String color, Double area){
        this.type  = type ;
        this.color = color;
        this.area  = area ;
    }

    public Shape(String type, String color){
        this(type, color, 0.);
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return type + "(" + color + ", " + area + ")";
    }
}

