package day1216;

import java.util.Scanner;

public class Ex2Random {

	public static void main(String[] args) {
		// 1~100 사이 임의 수 rnd 생성 후 숫자 알아맞추기
		/* ex
		 * 1회 : 50
		 * 50보다 큽니다
		 * 2회 : 80
		 * 80보다 작습니다
		 * .
		 * .
		 * .
		 * 6회 : 60
		 * 정답입니다 => 맞출경우 프로그램 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		int val, rnd;
		int i = 0;
		
		rnd = (int) (Math.random() * 100 + 1);
		while(true) {
			System.out.print(++i + "회 : ");
			val = sc.nextInt();
			if(val>rnd) System.out.println(val + "보다 작습니다");
			else if(val<rnd) System.out.println(val + "보다 큽니다");
			else {
				System.out.println("정답입니다");
				break;
			}
		}

	}

}
