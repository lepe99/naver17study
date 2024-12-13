package day1213;

import java.util.Scanner;

public class Ex4Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("숫자 입력");
		num = sc.nextInt();
		sc.close();
		
		switch(num % 2) { // 안에 수식
		case 0:
			System.out.println("짝수입니다");
			break;
		default:
			System.out.println("홀수입니다");
		}
		//동일방식 if로 구현
		if(num % 2 == 0) System.out.println("짝수입니다");
		else System.out.println("홀수입니다");

	}

}
