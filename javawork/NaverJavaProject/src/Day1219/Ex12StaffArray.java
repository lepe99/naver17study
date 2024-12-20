package day1219;

import java.text.NumberFormat;
import java.util.Scanner;

/*
 * showTitle : 제목 출력 / 사원명 직급 기본급 수당 가족수당 세금 실수령액
 * inputStaff : 한개의 사원 데이터 입력
 * writeStaff : 한개의 사원 데이터 출력
 * 인원 수 입력 후 인원수만큼 배열 메모리 할당
 * 배열에 데이터 입력 후 생성자 통해서 데이터 저장하기
 * 제목 출력
 * 반복문 통해서 데이터 출력하는 메서드 호출
 */

public class Ex12StaffArray {
	
	
	public static void showTitle() {
		System.out.println("=".repeat(60));
		System.out.println("사원명\t직급\t기본급\t\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(60));
	}
	

	public static void writeStaff(Staff staff) {
		NumberFormat nf = NumberFormat.getInstance(); // 3자리 넘으면 구분자 넣어줌
		// nf 의 출력은 String
		
		System.out.print(staff.getStaffName() + "\t");
		System.out.print(staff.getPosition() + "\t");
		System.out.print(nf.format(staff.getPay()) + "\t");
		System.out.print(nf.format(staff.getExtraPay()) + "\t");
		System.out.print(nf.format(staff.getFamPay()) + "\t");
		System.out.print(nf.format(staff.getTax()) + "\t");
		System.out.print(nf.format(staff.getNetPay()) + "\t");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		Staff[] staff;
		System.out.print("입력할 사원 수 : ");
		num = Integer.parseInt(sc.nextLine());
		staff = new Staff[num];
		
		for(int i=0; i<num; i++) {
			System.out.println("=".repeat(30));
			System.out.printf("사원명 입력(%d/%d) : ", i + 1, num);
			String staffName = sc.nextLine();
			System.out.printf("직급 입력(%d/%d) : ", i + 1, num);
			String position = sc.nextLine();
			System.out.printf("가족 수 입력(%d/%d) : ", i + 1, num);
			int familyNum = Integer.parseInt(sc.nextLine());
			staff[i] = new Staff(staffName, position, familyNum); // 생성자 사용하였기에 setter 함수 통한 생성은 필요 x
		}
		
		showTitle();
		
		for(Staff s : staff) 
			writeStaff(s);
	
	}

}
