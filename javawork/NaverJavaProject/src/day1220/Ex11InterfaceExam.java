package day1220;
/*
 * Command 라는 인터페이스에 process() 추상 메서드 추가
 * 인터페이스 Command 를 구현하는 List, Insert, Delete, Update 클래스를 구현하시오
 * 메인에서 while 문을 통해 다음과 같이 메뉴가 나오면
 * 1. 추가	2. 출력	3. 삭제	4. 수정	5. 종료
 * 1번을 누르면 데이터가 추가되었습니다
 * 2 ~ 출력합니다
 * 3 ~ 삭제되었습니다
 * 4 ~ 수정 ~
 * 5 ~ 프로그램을 종료합니다 -> 실제 종료
 * 
 * 호출하는 메서드는
 * public static void dbProcess(Command comm) {
 * 		comm.process(); // 이 부분이 다형성 처리가 되어야함
 * }
 */

import java.util.Scanner;

interface Command {
	public void process();
}

class List implements Command {
	public void process() {
		System.out.println("데이터가 추가되었습니다");
	}
}

class Insert implements Command {
	public void process() {
		System.out.println("데이터를 출력합니다");
	}
}

class Delete implements Command {
	public void process() {
		System.out.println("데이터가 삭제되었습니다");
	}
}

class Update implements Command {
	public void process() {
		System.out.println("데이터가 수정되었습니다");
	}
}



public class Ex11InterfaceExam {
	public static void dbProcess(Command comm) {
		comm.process();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Loop:
		while(true) {
			System.out.println("=".repeat(40));
			System.out.println("1. 추가\t2. 출력\t3. 삭제\t4. 수정\t5. 종료");
			System.out.print("수행할 작업 입력 : ");
			int task = Integer.parseInt(sc.nextLine());
			System.out.println("=".repeat(40));
			
			switch(task) {
				case 1 -> {
					Command comm = new List();
					dbProcess(comm);
				}
				case 2 -> {
					Command comm = new Insert();
					dbProcess(comm);
				}
				case 3 -> {
					Command comm = new Delete();
					dbProcess(comm);
				}
				case 4 -> {
					Command comm = new Update();
					dbProcess(comm);
				}
					case 5 -> {
					System.out.println("프로그램을 종료합니다");
					break Loop;
				}
				default -> {
					System.out.println("잘못된 입력입니다. 다시 입력해주세요");
					continue;
				}
			}	
			
		}

	} 

}
