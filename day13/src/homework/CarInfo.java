package homework;

import java.util.Scanner;

class Car {
	protected int speed = 0, num = 0;
	protected String name = null, color = null, address = null;
	
	// ������
	// �⺻ ������: �ƹ��͵� �� ��
	public Car() {}

	// �ڵ����� ���� �缭 ��ȣ�Ǳ��� �޾ƿ´ٰ� �����ϰ�, ��ȣ/�̸�/���� �� �Է¹޵��� �Ѵ�.
	public Car(int num, String name, String color) {
		this.num = (num > 0 ? num : -num) % 10000;
		this.name = name;
		this.color = color;
	}
	
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
	protected int fare = 0;
	protected String comp = null;
	
	public LentCar() {}
	public LentCar(int num, String name, String color) {
		super(num, name, color);
	}
	
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

		// �Է¹޴� �κ�
		System.out.print("���� �̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
		System.out.print("���� ������ �Է��ϼ��� : ");
		String color = sc.nextLine();
		
		System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt(); sc.nextLine();

		// �Է¹��� ������ �̿��Ͽ� �ڵ��� ����
		LentCar supercar = new LentCar(num, name, color);

		// �ٽ� �Է� �ޱ�
		System.out.print("������ �ּҸ� �Է��ϼ��� : ");
		supercar.moveAddress(sc.nextLine());

		System.out.print("���� �ӵ��� �Է��ϼ��� : ");
		supercar.accelerate(sc.nextInt());

		System.out.print("��Ʈ�� �Է��ϼ��� : ");
		supercar.setFare(sc.nextInt()); sc.nextLine();
		
		System.out.print("��Ʈȸ�縦 �Է��ϼ��� : ");
		supercar.setComp(sc.nextLine());

		// ����ϴ� �κ�
		System.out.printf("���� �ӵ� : %d\n"
				+ "���� �̸� : %s\n"
				+ "���� ��ȣ : %04d\n"
				+ "���� ���� : %s\n"
				+ "������ �ּ� : %s\n"
				+ "��Ʈ ��� : %d\n"
				+ "��Ʈ ȸ�� : %s\n",
				supercar.getSpeed(), supercar.getName(), supercar.getNumber(),
				supercar.getColor(), supercar.getAddress(),
				supercar.getFare(), supercar.getComp());
		
		// ���Ӱ� ����
		for(int i=1;;i*=-1) {
			System.out.printf("�ӵ��� �󸶳� %c���ðڽ��ϱ�? : ", i>0 ? '��':'��');
			supercar.accelerate(sc.nextInt() * i);
			System.out.printf("���� �ӵ� : %d\n", supercar.getSpeed());
			if(i<0) break;
		}
		sc.close();
	}
}