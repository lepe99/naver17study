package day1212;

import java.util.Scanner;

public class Ex14If {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score;
		String grade;
		
		System.out.println("점수를 입력해주세요");
		score = sc.nextInt();
		sc.close();
		// 점수가 0-100의 값을 벗어나면 메서드 종료
		if(!(score >= 0 && score <= 100)) {
//		if(score < 0 || score > 100) { // 위와 동일
			System.out.println("값의 범위를 벗어났습니다");
			return; // 현재 메서드를 종료
		}
		if(score >= 90)
			grade = "A";
		else if(score >= 80)
			grade = "B";
		else if(score >= 70)
			grade = "C";
		else if(score >= 60)
			grade = "D";
		else
			grade = "F";
		
		System.out.printf("%d점의 학점은 %s학점입니다", score, grade);
	}

}
