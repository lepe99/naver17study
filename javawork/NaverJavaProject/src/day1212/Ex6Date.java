package day1212;

import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// 현재 날짜와 시간을 알아보자
		// Date 클래스는 jdk1.1 이후에 deprecate 됨 - Calendar를 권장
		// 메소드명 치면 api 임포트 가능
		// 에러 해결방안 단축키 cmd + 1
		
		Date today = new Date();
		int curYear = today.getYear() + 1900; // 1900을 뺀 값을 반
		int curMonth = today.getMonth() + 1; // 0~11을 반환하므로 +1
		int curDate = today.getDate();
		
		System.out.println("현재년도 : " + curYear);
		System.out.println("현재월 : " + curMonth);
		System.out.println("현재일 : " + curDate);
		System.out.println(today.getHours() + "시 " + today.getMinutes() + "분");
		
		// 요일 숫자 구하기 (0~6 : 일~토)
		int weekDay = today.getDay();
		System.out.println(weekDay);
		
		// 오늘은 ㅇ요일입니다
		String week = weekDay == 1 ? "월" : weekDay == 2 ? "화" : weekDay == 3 ? "수" 
					: weekDay == 4 ? "목" : weekDay == 5 ? "금" : weekDay == 6 ? "토" : "일";
		System.out.printf("오늘은 %s요일입니다", week);
		
	}

}
