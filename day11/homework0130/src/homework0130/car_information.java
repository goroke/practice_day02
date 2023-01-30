package homework0130;

import java.util.Scanner;

class car {
	private int p_speed = 0, p_num = 0;
	private String p_name = null, p_color = null, p_address = null;
	
	// 생성자
	// 자동차를 새로 사서 번호판까지 받아온다고 가정하고, 번호/이름/색상 만 입력받도록 한다.
	public car(int num, String name, String color) {
		p_num = (num > 0 ? num : -num) % 10000;
		p_name = name;
		p_color = color;
	}

	// 차에 특정 색을 입힌다.
	public void paint(String color) {
		p_color = color;
	}
	
	public String getColor() {
		return p_color;
	}

	// 차 이름을 바꾼다.
	public void rename(String name) {
		p_name = name;
	}
	
	public String getName() {
		return p_name;
	}

	// 차 주소지를 바꾼다.
	public void moveAddress(String address) {
		p_address = address;
	}
	
	public String getAddress() {
		return p_address == null? "자동차 판매점" : p_address;
	}

	// 자동차의 속도를 지정된 수만큼 올린다(음수를 넣으면 내려간다).
	public void accelerate(int dv) {
		p_speed += dv;
	}
	
	public int getSpeed() {
		return p_speed;
	}

	public int getNumber() {
		return p_num;
	}
}

public class car_information {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = null, color = null, address = null;
		int number = 0, speed = 0;
		
		// 입력받는 부분
		System.out.print("차 이름을 입력하시오. : ");
		name = sc.nextLine();
		
		System.out.print("차 색을 입력하시오. : ");
		color = sc.nextLine();
		
		System.out.print("차량 번호를 입력하시오. : ");
		number = sc.nextInt(); sc.nextLine();

		System.out.print("운전자 주소를 입력하시오. : ");
		address = sc.nextLine();

		System.out.print("속도를 입력하시오. : ");
		speed = sc.nextInt();
		
		// 자동차 생성
		car yourcar = new car(number, name, color);
		
		yourcar.moveAddress(address);	// 입력받은 곳으로 주소지를 옮긴다.
		yourcar.accelerate(speed);	// 입력받은 속도로 가속한다.
		
		// 결과물
		System.out.printf("차 이름 : %s\n"
				+ "차 색 : %s\n"
				+ "차량 번호 : %04d\n"
				+ "운전자 주소 :  %s\n"
				+ "속도 :  %d\n",
				yourcar.getName(), yourcar.getColor(), yourcar.getNumber(),
				yourcar.getAddress(), yourcar.getSpeed());
		
		sc.close();
	} // end of main()

}