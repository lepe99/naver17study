package day1223;
import java.util.Date;
// NumberFormatException
import java.util.Scanner;

public class Ex8Exception {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int birthYear, age;
		
		try {
			System.out.println("태어난 년도는?");
			birthYear = Integer.parseInt(sc.nextLine()); // 잘못 입력 시 바로 catch 로 이동
			
			Date date = null;
			age = (date.getYear() + 1900) - birthYear;
			
			System.out.println("내 나이는 " + age + "세 입니다");
			
		} catch (NumberFormatException e) {
			System.out.println("숫자로만 입력해주세요 : " + e.getMessage());
			
		} catch (NullPointerException e) {
			System.out.println("date 변수가 null 입니다 : " + e.getMessage()); 
			// catch 문 다중 사용해서 여러 종류 예외 다르게 처리 가능
		}

		System.out.println("정상종료");

	}

}
