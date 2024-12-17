package day1217;

import java.util.Date;
import java.util.Scanner;

public class Ex1Calendar {

	public static void main(String[] args) {
		/*
		 * 년도와 월을 입력하면 해당월의 달력을 출력하시오
		 * 달력이 제대로 나오게 하려면
		 * 1. 그 월의 1일이 무슨 요일인가?
		 * 2. 그 월이 몇일까지 있는가? (윤년 처리)
		 */
		Scanner sc = new Scanner(System.in);
		int inputYear, inputMonth;
		int endDays; // 몇일까지 있는지
		int weekDay; // 요일 숫자
		boolean leapYear;
		
		System.out.print("년도 입력 : ");
		inputYear = sc.nextInt();
		System.out.print("월 입력 : ");
		inputMonth = sc.nextInt();
		
		// 오입력 처리
		if(inputMonth<1 || inputMonth>12) {
			System.out.println("잘못된 월입니다");
			return; // main 메서드 종료
		}
		
		// 윤년 계산
		leapYear = inputYear % 4 == 0 && inputYear % 100 != 0 || inputYear % 400 == 0;
		if(leapYear) System.out.println(inputYear + "년은 윤년입니다");
		else System.out.println(inputYear + "년은 평년입니다");
		
		// 입력한 년도와 월의 1일에 대한 Date 클래스 생성
		Date inputDate = new Date(inputYear - 1900, inputMonth - 1, 1);
		weekDay = inputDate.getDay(); // 0~6 일~토
		
		// 해당 월이 몇일까지 있는지 구하기
		switch(inputMonth) {
		case 4, 6, 9, 11:
			endDays = 30;
			break;
		case 2:
			endDays = leapYear ? 29 : 28;
			break;
		default:
			endDays = 31;
			break;
		}
		
		// 출력
		System.out.println("=".repeat(50));
		System.out.println("\t\t[" + inputYear + "년 " + inputMonth + "월]");
		System.out.println("=".repeat(50));
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));
		
		// weekDay 숫자만큼 탭
		for(int i=1; i<=weekDay; i++) 
			System.out.print("\t");
	
		// 1일부터 endDays 까지 출력 (토요일은 출력 후 엔터)
		for(int i=1; i<=endDays; i++) {
			++weekDay;
			System.out.printf("%2d\t", i);
			if(weekDay % 7 == 0)
				System.out.println();
		}
		
		
	}

}
