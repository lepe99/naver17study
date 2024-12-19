package Day1219;

import java.util.Scanner;

public class Ex1ObjectArray {
	Student[] stuArray = new Student[3]; // 초기값 null
	
	public void inputData() {
		Scanner sc = new Scanner(System.in);
//		System.out.println("inputData"); // 확인용
//		for(Student s : stuArray) { // s는 stuArray 참조하는 새로운 주소. 할당할 때 쓰면 안됨
		for(int i=0; i<stuArray.length; i++) {
			// 생성
			stuArray[i] = new Student();
			
			System.out.printf("학생 이름 : ");
			String name = sc.nextLine();
			System.out.printf("혈액형 : ");
			String blood = sc.nextLine();
			System.out.printf("태어난 년도 : ");
			int birthYear = Integer.parseInt(sc.nextLine());
			System.out.printf("점수 : ");
			int score = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			// s에 데이터 넣기
			stuArray[i].setStuName(name);
			stuArray[i].setStuBlood(blood);
			stuArray[i].setStuBirthYear(birthYear);
			stuArray[i].setStuScore(score);
		}
	}
	
	public static void showTitle() {
//		System.out.println("showTitle");
		System.out.println("이름\t혈액형\t나이\t점수\t학점");
		System.out.println("=".repeat(60));
	}
	
	public void writeDataArray() {
//		System.out.println("write");
		for(Student s : stuArray) {
			System.out.print(s.getStuName() + "\t");
			System.out.print(s.getStuBlood().toUpperCase() + "형\t"); // 항상 대문자로
			System.out.print(s.getAge() + "\t");
			System.out.print(s.getScore() + "\t");
			System.out.print(s.getScoreGrade() + "\t");
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		Ex1ObjectArray ex1 = new Ex1ObjectArray();
		// 데이터 입력
		ex1.inputData();
		// 제목 출력
		showTitle(); // 같은 클래스 내 static 메서드
		// 데이터 출력
		ex1.writeDataArray();
	}

}
