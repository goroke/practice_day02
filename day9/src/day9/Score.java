package day9;

import java.util.Scanner;

public class Score {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 이름 입력
		System.out.print("정보를 입력해주세요.\n이름: ");
		String name = sc.nextLine();
		
		// 학과 입력
		System.out.print("학과: ");
		String major = sc.nextLine();
		
		// 과목별 점수 입력
		System.out.println("\n개인 정보가 입력되었습니다.\n과목별 점수를 입력해주세요.");

		System.out.print("영어　　: ");
		int score_eng = sc.nextInt();
		
		System.out.print("물리학　: ");
		int score_phy = sc.nextInt();

		System.out.print("미적분학: ");
		int score_cal = sc.nextInt();
		
		System.out.println("\n점수 정보가 입력되었습니다.\n주소를 입력해주세요.");
		System.out.print("주소: ");
		sc.nextLine();	// 남아있는 줄바꿈 문자 처리
		String address = sc.nextLine();

		// 결과물
		System.out.printf("\n입력하신 정보입니다\n"
				+ "이름: %s, 학과명: %s\n"
				+ "영어: %d, 물리학: %d, 미적분학: %d\n"
				+ "총점: %d, 평균: %.1f\n"
				+ "주소: %s",
				name, major,
				score_eng, score_phy, score_cal,
				score_eng + score_phy + score_cal, (score_eng + score_phy + score_cal) / 3.,
				address);
	}
	
}
