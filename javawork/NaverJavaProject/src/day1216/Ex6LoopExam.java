package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// str 입력후 엔터 => 대문자 소문자 숫자 각각의 개수를 구해서 출력
		// length(), charAt(index)
		int cntUp = 0, cntLow = 0, cntNum = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요");
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') cntLow++;
			else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') cntUp++;
			else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') cntNum++;
		}
		System.out.println("대문자 개수 : " + cntUp);
		System.out.println("소문자 개수 : " + cntLow);
		System.out.println("숫자 개수 : " + cntNum);
	}

}
