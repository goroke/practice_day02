package day9;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.print("������ �Է����ּ���: ");
		year = sc.nextInt();
		
		// and ������ or ���꺸�� ���� �̷������. (���ϱⰡ ���ϱ⺸�� ���� ���Ǵ� ����)
		if(year % 4 == 0 && year % 25 > 0 || year % 400 == 0)
			System.out.printf("%d���� �����Դϴ�.", year);
		
		else
			System.out.printf("%d���� ������ �ƴմϴ�.", year);
	}
}
