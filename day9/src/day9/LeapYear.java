package day9;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year;
		
		System.out.print("연도를 입력해주세요: ");
		year = sc.nextInt();
		
		// and 연산이 or 연산보다 먼저 이루어진다. (곱하기가 더하기보다 먼저 계산되는 느낌)
		if(year % 4 == 0 && year % 25 > 0 || year % 400 == 0)
			System.out.printf("%d년은 윤년입니다.", year);
		
		else
			System.out.printf("%d년은 윤년이 아닙니다.", year);
	}
}
