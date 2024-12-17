package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		String[] memberStrings = {"강호동", "김태희", "손미나", "이지혜", "송중기", "김사랑", "손석구", "박미나", "강리나", "김수로"};
		String searchName;
		Scanner sc = new Scanner(System.in);
		/*
		 * 검색할 성씨는? 이
		 * 	이지혜
		 * 총 1명 검색
		 * 없으면 (cnt=0) "홍" 씨 성을 가진 멤버는 없습니다
		 * 대소문자 상관 없이 exit 입력 시 종료
		 */
		
		while(true) {
			int count = 0;
			System.out.print("검색 할 성씨는? : ");
			searchName = sc.nextLine();
			
			if(searchName.equalsIgnoreCase("exit")) {
				System.out.println("작업을 종료합니다");
				break;
			}
			for(int i=0; i<memberStrings.length; i++) {
				if(memberStrings[i].startsWith(searchName)) {
					System.out.println(" " + memberStrings[i]);
					count++;
				}
			}
			if(count == 0) System.out.println("\"" + searchName + "\" 씨 성을 가진 멤버는 없습니다");
			else System.out.println("총 " + count + "명 검색");
		}
	}

}
