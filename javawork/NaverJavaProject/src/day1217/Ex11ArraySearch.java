package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		String[] memberStrings = {"강호동", "김태희", "손미나", "이지혜", "송중기", "김사랑", "손석구", "박미나", "강리나", "김수로"};
		String searchName;
		boolean find = false;
		Scanner sc = new Scanner(System.in);
		/*
		 * 이름 입력하면 몇번째에 있는지 출력 없을경우 "해당 이름은 없습니다"
		 * 반복적 검색하다가 종료 하고싶으면 "종료"
		 */
		
		while(true) {
			System.out.print("찾을 이름 입력 : ");
			searchName = sc.nextLine();
			
			if(searchName.equals("종료")) {
				System.out.println("작업을 종료합니다");
				break;
			}
			
			for(int i=0; i<memberStrings.length; i++) {
				if(searchName.equals(memberStrings[i])) {
					find = true;
					System.out.println("해당 이름은 " + (i + 1) + "번째에 있습니다");
					break;
				}
			}
			if(!find) System.out.println("해당 이름은 없습니다");
		}
	}

}
