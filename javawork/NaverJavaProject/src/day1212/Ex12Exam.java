package day1212;

import java.util.Scanner;

public class Ex12Exam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int scoreJava, scoreHtml, scoreSpring;
		
		System.out.println("이름 입력");
		name = sc.nextLine();
		System.out.println("java 점수 입력");
		scoreJava = sc.nextInt();
		System.out.println("html 점수 입력");
		scoreHtml = sc.nextInt();
		System.out.println("spring 점수 입력");
		scoreSpring = sc.nextInt();
		sc.close();
		
		int sum = scoreJava + scoreHtml + scoreSpring;
		double avg = sum / 3.0;
		String grade = avg >= 90 ? "우등장학생" : avg >= 80 ? "장학금 50%" : "노력";
		boolean pass = scoreJava >= 50 && scoreHtml >= 50 && scoreSpring >= 50 && avg >= 70 ? true : false;
		
		System.out.println("\n------------------------\n");
		System.out.println(name + "님의 결과");
		System.out.println("총점 : " + sum + "점");
		System.out.printf("평균 : %.1f점\n", avg);
		System.out.println("등급 : " + grade);
		System.out.println(pass ? "합격입니다." : "불합격입니다.");
		System.out.println("\n------------------------");
					 
	}

}
