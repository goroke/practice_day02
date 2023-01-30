package homework0130;

import java.util.Scanner;

public class lotto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {0, 0, 0, 0, 0, 0};
		int   i = 0;
		
		// i번째 요소를 순환하면서 입력받는다. (i = 0~5)
		mainloop: while(i < 6) {
			System.out.print("로또번호 입력 : ");
			a[i] = sc.nextInt();
			
			// 로또 번호 범위를 벗어나는 경우는 다시 입력받는다
			if(a[i] < 1 || a[i] > 45) {
				System.out.println("번호는 1 ~ 45 사이의 정수로 입력해주세요!");
				continue;
			}
			
			for(int j = 0; j < i; j++) {
				
				// 중복이 있는 경우
				if(a[i] == a[j]) {
					System.out.println("같은 번호가 있습니다!");
					continue mainloop;
				}
			}
			
			// 중복이 없는 경우만 다음 번호를 입력받는다.
			i++;
		} // end of while
		
		System.out.print("입력된 로또번호 : ");
		for (int item : a) System.out.printf("\t%d", item);
		
		sc.close();
	} // end of main()

}
