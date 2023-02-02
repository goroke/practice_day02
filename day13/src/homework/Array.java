package homework;

public class Array {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		/*
		// 원소 교환하기(임시 변수 없이)
		for(int i=0; i+1 < num.length; i+=2) {
			num[i+1] += num[i] -= num[i+1]; // (A, B) → (A-B, B) → (A-B, A)
			num[i] = num[i+1] - num[i];
		}
		*/

		// 원소 교환하기(임시 변수 사용)
		for(int i=0; i+1 < num.length;) {
			int temp = num[i]; //a b a
			num[i] = num[++i];   //b b a
			num[i++] = temp;   //b a a
		}

		// 결과값 출력
		for(int n : num) System.out.print(n+" ");
		
		// 꼼수
		//for(int i=0; i<num.length; i++) System.out.print(num[i+(i%2>0?-1:1)]+" ");
	}
}
