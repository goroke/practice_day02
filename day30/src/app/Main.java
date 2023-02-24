package app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작할 프로그램을 선택해주세요.");
		System.out.println("1. Select");
		System.out.println("2. Insert");
		System.out.println("3. Statistics (avg, sum, count)");
		System.out.println("4. Group By");
		
		switch (sc.nextInt()) {
			case 1 -> new Select();
			case 2 -> new Insert();
			case 3 -> new Statistics();
			case 4 -> new Select();
			default-> System.out.println("잘못 고르셨습니다.");
		}
	}

}
