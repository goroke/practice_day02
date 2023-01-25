public class DataEx03{
    public static void main(String[] args) {
        //byte var1=127;
        short var1=127; // 128 이라는 값이 들어가므로, byte 타입은 알맞지 않다.
        short var2=128;
        int var3=128;
        long var4=128L;
        var4 = var1;
        System.out.println(var1+ ", " + var2);
        var1 = (short) var3;    // 기본적으로 4바이트인 int가 되므로 강제로 변환해줘야 한다.
        System.out.println(var1+ ", " + var3);
        
        // float var5=123456.789123;
        float var5=123456.789123f;  // f를 붙여 float형으로 바꿔줘야 에러가 나지 않는다.
        double var6=123456.789123;
        // var5 =var6;
        var5 = (float) var6; // float 변수에 double 값을 넣을 수 없으므로, 값을 float로 캐스팅한다.
        System.out.println(var5+ ", " + var6);
        var6 = var5;
        System.out.println(var5+ ", " + var6);
    }
}