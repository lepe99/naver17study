package day1216;

import java.util.Scanner;

public class Ex8LoopExam {

	public static void main(String[] args) {
		// 이름을 입력하면 그 중 '김, 이, 그외' 성을 가진 인원수를 각각 구하여 출력
		// while문, "끝"을 입력하면 탈출
		// String 메서드 : startsWith, equals
		
		Scanner sc = new Scanner(System.in);
		int cntKim = 0, cntLee = 0, cntEtc = 0;
		String name;
		
		while(true) {
			System.out.print("이름을 입력하세요 : ");
			name = sc.nextLine();
			if(name.equals("끝")) break;
			if(name.startsWith("김")) cntKim++;
			else if(name.startsWith("이")) cntLee++;
			else cntEtc++;
		
		}
		System.out.println("김씨 성 수 : " + cntKim);
		System.out.println("이씨 성 수 : " + cntLee);
		System.out.println("그외 성 수 : " + cntEtc);
	}

}
