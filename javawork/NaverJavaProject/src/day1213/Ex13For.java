package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		double avg;
		
		for(int i=0; i<5; i++) {
			System.out.print("나이 입력(" + (i + 1) + " / 5) : ");
			sum += sc.nextInt();
		}
		avg = (double) sum / 5;
		
		System.out.printf("평균 나이는 %4.1f세", avg);
		
		
	}
		
}
