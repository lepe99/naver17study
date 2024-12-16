package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int n = sc.nextInt();
		int sum = 0;
		sc.close();
		
		for(int i=1; i<=n; i++) sum += i;
		
		System.out.printf("1부터 %d까지의 합 : %d", n, sum);
		
	}
		
}
