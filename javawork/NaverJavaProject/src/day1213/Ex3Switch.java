package day1213;

import java.util.Scanner;

public class Ex3Switch {

	public static void main(String[] args) {
		// 년도와 월을 받고 윤, 평년 여부 출력
		// 그 월이 몇일까지 있는지?
		// 윤년 -> 년%4==0 && 년%100!=0 || 년%400=0
		
		Scanner sc = new Scanner(System.in);
		int year, month, days;
		
		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();
		sc.close();
		
		boolean b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0; // true면 윤년
		
		if(b) System.out.println(year + "년은 윤년입니다"); // b (트루) !b (폴스)
		else System.out.println(year + "년은 평년입니다");
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			days = 31;
			break;
		case 4, 6, 9, 11:
			days = 30;
			break;
		case 2:
			days = b ? 29 : 28;
			break;
		default:
			days = -1;
		}
		
		if(days == -1) System.out.println("1 ~ 12월을 벗어난 값입니다");
		else System.out.printf("%d년 %d월은 %d일 까지 있습니다", year, month, days);	
			
		

	}

}
