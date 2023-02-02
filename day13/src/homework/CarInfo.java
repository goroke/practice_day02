package homework;

import java.util.Scanner;

class Car {
	protected int speed = 0, num = 0;
	protected String name = null, color = null, address = null;
	
	// 생성자
	// 기본 생성자: 아무것도 안 함
	public Car() {}

	// 자동차를 새로 사서 번호판까지 받아온다고 가정하고, 번호/이름/색상 만 입력받도록 한다.
	public Car(int num, String name, String color) {
		this.num = (num > 0 ? num : -num) % 10000;
		this.name = name;
		this.color = color;
	}
	
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
	protected int fare = 0;
	protected String comp = null;
	
	public LentCar() {}
	public LentCar(int num, String name, String color) {
		super(num, name, color);
	}
	
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

		// 입력받는 부분
		System.out.print("차량 이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("차량 색깔을 입력하세요 : ");
		String color = sc.nextLine();
		
		System.out.print("차량 번호를 입력하세요 : ");
		int num = sc.nextInt(); sc.nextLine();

		// 입력받은 정보를 이용하여 자동차 생성
		LentCar supercar = new LentCar(num, name, color);

		// 다시 입력 받기
		System.out.print("운전자 주소를 입력하세요 : ");
		supercar.moveAddress(sc.nextLine());

		System.out.print("현재 속도를 입력하세요 : ");
		supercar.accelerate(sc.nextInt());

		System.out.print("렌트비를 입력하세요 : ");
		supercar.setFare(sc.nextInt()); sc.nextLine();
		
		System.out.print("렌트회사를 입력하세요 : ");
		supercar.setComp(sc.nextLine());

		// 출력하는 부분
		System.out.printf("현재 속도 : %d\n"
				+ "차량 이름 : %s\n"
				+ "차량 번호 : %04d\n"
				+ "차량 색깔 : %s\n"
				+ "운전자 주소 : %s\n"
				+ "렌트 요금 : %d\n"
				+ "렌트 회사 : %s\n",
				supercar.getSpeed(), supercar.getName(), supercar.getNumber(),
				supercar.getColor(), supercar.getAddress(),
				supercar.getFare(), supercar.getComp());
		
		// 가속과 감속
		for(int i=1;;i*=-1) {
			System.out.printf("속도를 얼마나 %c리시겠습니까? : ", i>0 ? '올':'내');
			supercar.accelerate(sc.nextInt() * i);
			System.out.printf("현재 속도 : %d\n", supercar.getSpeed());
			if(i<0) break;
		}
		sc.close();
	}
}