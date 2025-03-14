package day1213;

import java.util.Scanner;

public class Ex9While {

	public static void main(String[] args) {
		/* 1글자씩 입력하다가 x(대소문자 상관없음)를 입력하면 빠져나와서
		 * 입력한 데이터들을 분석한 결과를 출력하시오
		 * 대문자 : 3
		 * 소문자 : 3
		 * 숫자 : 4
		 */
		Scanner sc = new Scanner(System.in);
		char ch;
		int cntUpper = 0, cntLower = 0, cntNum = 0;
		
		
		while(true) {
			System.out.print("데이터 입력(종료 : x) : ");
			ch = sc.nextLine().charAt(0);
			if (ch == 'x' || ch == 'X') break;

			if(ch >= 'a' && ch <= 'z') cntLower++;
			else if(ch >= 'A' && ch <= 'Z') cntUpper++;
			else if(ch >= '0' && ch <= '9') cntNum++;
			
//			if(ch >= 97 && ch <= 122) cntLower++;
//			else if(ch >= 65 && ch <= 90) cntUpper++;
//			else if(ch >= 48 && ch <= 57) cntNum++;
			
		}
		sc.close();
		
		System.out.println("대문자 : " + cntUpper);
		System.out.println("소문자 : " + cntLower);
		System.out.println("숫자 : " + cntNum);
	
	}

}
