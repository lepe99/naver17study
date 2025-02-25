package day1212;

import java.time.*;
import java.util.Scanner;

public class Ex11ExamWithTime {

	public static void main(String[] args) {
		int year, month, day;
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		System.out.println("일 입력");
		day = sc.nextInt();
		sc.close();
		
		LocalDate myDate = LocalDate.of(year, month, day);
		
		DayOfWeek weekNum = myDate.getDayOfWeek();
		
		char week = weekNum.getValue() == 1 ? '월'
				  : weekNum.getValue() == 2 ? '화'
				  : weekNum.getValue() == 3 ? '수'
				  : weekNum.getValue() == 4 ? '목'
				  : weekNum.getValue() == 5 ? '금'
				  : weekNum.getValue() == 6 ? '토' : '일';
		
		System.out.printf("%d년 %d월 %d일은 %c요일입니다.", year, month, day, week);
														  

		

	}

}
