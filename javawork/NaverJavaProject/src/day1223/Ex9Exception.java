package day1223;

import java.util.Date;
import java.util.Scanner;

// Ex8 예제에서 catch 두개를 하나로 합쳐보자
public class Ex9Exception {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int birthYear, age;
		
		try {
			System.out.println("태어난 년도는?");
			birthYear = Integer.parseInt(sc.nextLine()); // 잘못 입력 시 바로 catch 로 이동
			
			Date date = null;
			age = (date.getYear() + 1900) - birthYear;
			
			System.out.println("내 나이는 " + age + "세 입니다");
			
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("예외 발생 : " + e.getMessage());
			// 여러가지 예외를 하나의 방안으로 처리할 때 | 사용 (or) 
			// 둘 중 하나의 예외라도 발생 시 catch 로 이동한다
		}

		System.out.println("정상종료");

	}

}
