package LentCarInfo;

import java.util.Scanner;

class Car {
	private int speed = 0, num = 0;
	private String name = null, color = null, address = null;
	
	// 생성자
	// 기본 생성자: 아무것도 안 함
	public Car() {}
	
	// 차에 특정 색을 입힌다.
	public void paint(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color == null? "도색 필요" : color;
	}

	// 차 이름을 바꾼다.
	public void setName(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name == null? "제품 정보 없음" : name;
	}

	// 차 주소지를 바꾼다.
	public void moveAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address == null? "자동차 판매점" : address;
	}

	// 자동차의 속도를 지정된 수만큼 올린다(음수를 넣으면 내려간다).
	public void accelerate(int dv) {
		speed += dv;
	}
	
	public int getSpeed() {
		return speed;
	}

	// 차 번호를 설정한다
	// 0번은 설정하지 않은 상태이며, 설정 후 변경할 수 없다.
	public void setNumber(int num) {
		if(this.num == 0) this.num = num;
	}
	public int getNumber() {
		return num;
	}

}

class LentCar extends Car{
	private int fare = 0;
	private String comp = null;
	
	public LentCar() {}
	
	// 요금 정보 입출력
	public int  getFare() {return fare;}
	public void setFare(int fare) {this.fare = fare;}

	// 회사 정보 입출력
	public void setComp(String comp) {this.comp = comp;}
	public String getComp() {return comp == null? "소유 회사 없음" : comp;}

}

public class CarInfo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 자동차 생성
		LentCar supercar = new LentCar();
		
		// 입력받는 부분
		System.out.print("자동차종류 입력하시오 : ");
		supercar.setName(sc.nextLine());
		
		System.out.print("자동차색깔 입력하시오 : ");
		supercar.paint(sc.nextLine());
		
		System.out.print("자동차번호 입력하시오 : ");
		supercar.setNumber(sc.nextInt()); sc.nextLine();

		System.out.print("운전자주소 입력하시오 : ");
		supercar.moveAddress(sc.nextLine());

		System.out.print("자동차속도를 입력하시오 : ");
		supercar.accelerate(sc.nextInt());

		System.out.print("렌트비를 입력하십시오 : ");
		supercar.setFare(sc.nextInt()); sc.nextLine();
		
		System.out.print("렌트회사를 입력하십시오 : ");
		supercar.setComp(sc.nextLine());

		// 출력하는 부분
		System.out.printf("\n자동차종류 : %s\n"
				+ "자동차색깔 : %s\n"
				+ "자동차번호 : %04d\n"
				+ "운전자주소 : %s\n"
				+ "현재 자동차의 속도는 시속 %dkm/h 입니다.\n"
				+ "렌트요금 : %d\n",
				supercar.getName(), supercar.getColor(),
				supercar.getNumber(), supercar.getAddress(),
				supercar.getSpeed(), supercar.getFare());
		
		// 가속과 감속
		System.out.print("속도를 얼마나 올리시겠습니까 : ");
		supercar.accelerate(sc.nextInt());
		System.out.printf("현재 자동차의 속도는 시속 %dkm/h 입니다.\n", supercar.getSpeed());

		System.out.print("속도를 얼마나 내리시겠습니까 : ");
		supercar.accelerate(-sc.nextInt());
		System.out.printf("현재 자동차의 속도는 시속 %dkm/h 입니다.\n", supercar.getSpeed());		
	
		sc.close();
	}
}