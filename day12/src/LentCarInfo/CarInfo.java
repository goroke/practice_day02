package LentCarInfo;

import java.util.Scanner;

class Car {
	private int speed = 0, num = 0;
	private String name = null, color = null, address = null;
	
	// ������
	// �⺻ ������: �ƹ��͵� �� ��
	public Car() {}
	
	// ���� Ư�� ���� ������.
	public void paint(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color == null? "���� �ʿ�" : color;
	}

	// �� �̸��� �ٲ۴�.
	public void setName(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name == null? "��ǰ ���� ����" : name;
	}

	// �� �ּ����� �ٲ۴�.
	public void moveAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address == null? "�ڵ��� �Ǹ���" : address;
	}

	// �ڵ����� �ӵ��� ������ ����ŭ �ø���(������ ������ ��������).
	public void accelerate(int dv) {
		speed += dv;
	}
	
	public int getSpeed() {
		return speed;
	}

	// �� ��ȣ�� �����Ѵ�
	// 0���� �������� ���� �����̸�, ���� �� ������ �� ����.
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
	
	// ��� ���� �����
	public int  getFare() {return fare;}
	public void setFare(int fare) {this.fare = fare;}

	// ȸ�� ���� �����
	public void setComp(String comp) {this.comp = comp;}
	public String getComp() {return comp == null? "���� ȸ�� ����" : comp;}

}

public class CarInfo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// �ڵ��� ����
		LentCar supercar = new LentCar();
		
		// �Է¹޴� �κ�
		System.out.print("�ڵ������� �Է��Ͻÿ� : ");
		supercar.setName(sc.nextLine());
		
		System.out.print("�ڵ������� �Է��Ͻÿ� : ");
		supercar.paint(sc.nextLine());
		
		System.out.print("�ڵ�����ȣ �Է��Ͻÿ� : ");
		supercar.setNumber(sc.nextInt()); sc.nextLine();

		System.out.print("�������ּ� �Է��Ͻÿ� : ");
		supercar.moveAddress(sc.nextLine());

		System.out.print("�ڵ����ӵ��� �Է��Ͻÿ� : ");
		supercar.accelerate(sc.nextInt());

		System.out.print("��Ʈ�� �Է��Ͻʽÿ� : ");
		supercar.setFare(sc.nextInt()); sc.nextLine();
		
		System.out.print("��Ʈȸ�縦 �Է��Ͻʽÿ� : ");
		supercar.setComp(sc.nextLine());

		// ����ϴ� �κ�
		System.out.printf("\n�ڵ������� : %s\n"
				+ "�ڵ������� : %s\n"
				+ "�ڵ�����ȣ : %04d\n"
				+ "�������ּ� : %s\n"
				+ "���� �ڵ����� �ӵ��� �ü� %dkm/h �Դϴ�.\n"
				+ "��Ʈ��� : %d\n",
				supercar.getName(), supercar.getColor(),
				supercar.getNumber(), supercar.getAddress(),
				supercar.getSpeed(), supercar.getFare());
		
		// ���Ӱ� ����
		System.out.print("�ӵ��� �󸶳� �ø��ðڽ��ϱ� : ");
		supercar.accelerate(sc.nextInt());
		System.out.printf("���� �ڵ����� �ӵ��� �ü� %dkm/h �Դϴ�.\n", supercar.getSpeed());

		System.out.print("�ӵ��� �󸶳� �����ðڽ��ϱ� : ");
		supercar.accelerate(-sc.nextInt());
		System.out.printf("���� �ڵ����� �ӵ��� �ü� %dkm/h �Դϴ�.\n", supercar.getSpeed());		
	
		sc.close();
	}
}