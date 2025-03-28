package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Exam {

	public static void main(String[] args) {
		int year, month, day, weekNum;
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		System.out.println("일 입력");
		day = sc.nextInt();
		sc.close();
		
		Date myDate = new Date(year - 1900, month - 1, day);
		
		weekNum = myDate.getDay();
		char week = weekNum == 0 ? '일'
				  : weekNum == 1 ? '월'
				  : weekNum == 2 ? '화'
				  : weekNum == 3 ? '수'
				  : weekNum == 4 ? '목'
				  : weekNum == 5 ? '금' : '토';
		
		System.out.printf("%d년 %d월 %d일은 %c요일입니다.", year, month, day, week);
														  

		

	}

}
