package day1223;

import java.util.Scanner;

public class Ex10Throws {
	
	public static void sum(String a, String b) throws NumberFormatException { // 오류 발생하면 던짐
		int n1 = Integer.parseInt(a);
		int n2 = Integer.parseInt(b);
		int sum = n1 + n2;
		System.out.println(a + " + " + b + " = " + sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1 입력");
		String s1 = sc.nextLine();
		System.out.println("숫자2 입력");
		String s2 = sc.nextLine();
		
		try {
			sum(s1, s2);
		} catch (NumberFormatException e) {
			System.out.println("오류 발생 : " + e.getMessage());
		} finally {
			// 예외 발생 여부에 상관없이 무조건 실행되는 영역!
			System.out.println("Hello");
		}

		
		System.out.println("** 정상 종료 **");

	}

}
