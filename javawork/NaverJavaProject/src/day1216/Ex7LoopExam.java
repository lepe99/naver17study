package day1216;

import java.util.Scanner;

public class Ex7LoopExam {

	public static void main(String[] args) {
		// 1. 지수 승 구하기 2. 팩토리얼 구하기 3. 원의 넓이 구하기 4.종료
		// while 반복문에서 위의 메뉴가 나오면 번호를 입력하고 해당 데이터를 입력 후 결과값을 출력하시오
		// 1. 두 수 x, y를 입력 후 x의 y승(for문)을 구하여 출력
		// 2. 숫자 n을 입력 후 n! 구하시오 (for)
		// 3. 반지름 r을 입력하면 원의 넓이 구해서 출력(r^2*Math.PI
		// 이외의 값이 들어오면 "종료합니다" 출력 후 프로그램 종
		
		Scanner sc = new Scanner(System.in);
		int x, y; // 1번
		int n; // 2번
		int r;
		double area; // 3번
		int menu;
		
		Loop:
		while(true) {
			System.out.println("=".repeat(20));
			System.out.println("1. 지수 승 구하기");
			System.out.println("2. 팩토리얼 구하기");
			System.out.println("3. 원의 넓이 구하기");
			System.out.println("4. 프로그램 종료");
			System.out.println("=".repeat(20));
			System.out.print("원하는 메뉴를 입력하세요 : ");
			menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					int result = 1;
					System.out.print("지수의 밑 입력 : ");
					x = sc.nextInt();
					System.out.print("지수 입력 : ");
					y = sc.nextInt();
					for(int i=1; i<=y; i++)
						result *= x;
					System.out.printf("%d의 %d승은 %d입니다\n\n", x, y ,result);
					break; // switch문에서 continue는 적용 안됨, 이 상황에선 while문에 적용
					
				case 2:
					int fact = 1;
					System.out.print("팩토리얼 계산할 수 입력 : ");
					n = sc.nextInt();
					for(int i=n; i>=1; i--)
						fact *= i;
					System.out.printf("%d의 팩토리얼은 %d입니다\n\n", n, fact);
					break;
					
				case 3:
					System.out.print("원의 반지름(cm) 입력 : ");
					r = sc.nextInt();
					area = r * r * Math.PI;
					System.out.printf("원의 넓이는 %.2f(cm^2)입니다\n\n", area);
					break;
					
				case 4:
					System.out.println("프로그램을 종료합니다.");
					break Loop;
					
				default:
					System.out.println("잘못된 입력입니다\n");
					break;
			}
			
		}
	}

}
