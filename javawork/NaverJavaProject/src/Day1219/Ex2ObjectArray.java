package day1219;

import java.util.Scanner;

public class Ex2ObjectArray {
	
	public static void dataInput(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		System.out.print("학생 주소 : ");
		String addr = sc.nextLine();
		System.out.print("학생 혈액형 : ");
		String blood = sc.nextLine();
		
		s.changeStudent(name, addr, blood);
		System.out.println();
	}
	
	public static void showTitle() {
		System.out.println("이름\t혈액형\t주소");
		System.out.println("=".repeat(35));
	}
	
	public static void writeStudent(Student s) {
		System.out.print(s.getStuName() + "\t");
		System.out.print(s.getStuBlood().toUpperCase() + "형\t");
		System.out.print(s.getStuAddress());
		System.out.println();
		
	}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		Student[] stuArray;
		
		System.out.println("입력할 인원수는?");
		num = Integer.parseInt(sc.nextLine());
		// 메모리 할당
		stuArray = new Student[num];
		
		// 데이터 입력
		for(int i=0; i<stuArray.length; i++) {
			stuArray[i] = new Student(); // 생성
			dataInput(stuArray[i]); // 객체타입은 주소를 통해서 데이터가 들어온다
			
		}
		
		// 제목 출력
		showTitle();
		
		// 내용 출력
		for(int i=0; i<stuArray.length; i++) 
			writeStudent(stuArray[i]);
		
	}

}
