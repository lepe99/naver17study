package day1216;

import java.util.Scanner;

public class Ex9LoopExam {

	public static void main(String[] args) {
		System.out.println("다중 for문 이용해서 * 찍어보기");
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(20));
		
		// 별 점점 늘게
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(20));
		
		
		// 5~1
		
		
		for(int i=1; i<=5; i++) {
			for(int j=i; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("=".repeat(20));
	}	

}
