package day1213;

import java.util.Scanner;

public class Ex8While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, sum = 0, val = 1;
		System.out.println("숫자입력");
		n = sc.nextInt();
		sc.close();
		
		while(val <= n) {
			sum += val++;
		}
		System.out.printf("1부터 %d까지의 합계는 %d입니다", n, sum);
	}

}
