package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		/* 난수 구한 후 숫자 알아맞추기 
		 * 맞추면
		 * 계속하시겠습니까? y => 새로운 난수 발생, 카운트 변수 0으로 초기화
		 * !y => 프로그랭 종료
		 */
		Scanner sc = new Scanner(System.in);
		int val, rnd;
		
		Exit:	//레이블 사용, 레이블은 대소문자 상관없이 임의로 지정
			while(true) {
				rnd = (int) (Math.random() * 100 + 1);
				int i = 0;
				
				while(true) {
					System.out.print(++i + "회 : ");
//					val = sc.nextInt();  // 숫자, 문자 동시입력 시 문제 발생 확률 높음!
					val = Integer.parseInt(sc.nextLine());
					if(val>rnd) System.out.println(val + "보다 작습니다");
					else if(val<rnd) System.out.println(val + "보다 큽니다");
					else {
						System.out.println("정답입니다");
						System.out.print("계속하시겠습니까?(계속하려면 y) : ");
						if(sc.nextLine().charAt(0)=='y' || sc.nextLine().charAt(0)=='Y') {
							//charAt(문자번호) 문자 번호의 인덱스 char로 추출
							System.out.println("새로운 난수를 발생합니다");
							break; // 현재 속한 while문만 탈출
						} else 
							break Exit; //레이블 속한 while문 모두 탈출 // continue도 마찬가지 활용 
					}
				}
			}	

	}

}
