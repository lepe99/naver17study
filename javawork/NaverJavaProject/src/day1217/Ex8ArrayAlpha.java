package day1217;

import java.util.Scanner;

public class Ex8ArrayAlpha {

	public static void main(String[] args) {
		/*
		 *  영어 문장을 입력하면 알파벳을 분석해서 각 알파벳의 개수를 구하시오
		 */
		Scanner sc = new Scanner(System.in);
		String msg;
		int[] alpha = new int[26];
		
		System.out.print("영어 문장 입력 : ");
		msg = sc.nextLine().toLowerCase();
		
		//글자수만큼 반복
		for(int i=0; i<msg.length(); i ++) {
			char ch = msg.charAt(i);
			if(ch>='a' && ch<='z')
				alpha[ch - 'a']++;	
		}
		
		//출력
		for(int i=0; i<alpha.length; i++) {
//			System.out.printf("%c : %d개\t", 'a' + i, alpha[i]);
			System.out.print((char) ('a' + i) + " : " + alpha[i] + "개\t");
			if((i + 1) % 4 == 0) System.out.println(); // 한 줄에 4개씩 출력
		}
	}

}
