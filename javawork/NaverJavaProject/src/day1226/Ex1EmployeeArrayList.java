package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Ex1EmployeeArrayList {


	List<Employee> employeeList = new ArrayList<>();
	static final String EMPLOYEEFILE = "/Users/lee/naver1210/myemployee.txt";
	
	public Ex1EmployeeArrayList() {
		// 생성 시 파일 불러오기
		this.employeeFileRead();
	}
	
	// 파일 읽어서 employeeList 에 넣기
	public void employeeFileRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(EMPLOYEEFILE);
			br = new BufferedReader(fr);
			
			while(true) {
				String employeeInfo = br.readLine();
				if(employeeInfo == null) break;
				
				String[] s = employeeInfo.split("\\|");
				Employee employee = new Employee();
				employee.setEmployeeName(s[0]);
				employee.setAge(Integer.parseInt(s[1]));
				employee.setHp(s[2]);
				employee.setAddress(s[3]);
				
				// List 에 추가
				employeeList.add(employee);
			}
			
			System.out.println("총 " + employeeList.size() + "명 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("저장된 사원 정보가 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
//				e.printStackTrace(); 
			}
		}
	}
	
	// 파일 저장
	public void employeeFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(EMPLOYEEFILE);
			
			for(Employee employee : employeeList) {
				String s = employee.getEmployeeName() + "|"
						+ employee.getAge() + "|"
						+ employee.getHp() + "|"
						+ employee.getAddress() + "\r";
				// 파일에 추가
				fw.write(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 사원 추가
	public void addEmployee(Employee employee) {
		int idx = this.getSearchName(employee.getEmployeeName());
		// list 에 추가
		if(idx == -1) {
			employeeList.add(employee);
			System.out.println(employee.getEmployeeName() + "님의 정보를 추가했어요");
		} else
			System.out.println("이미 존재하는 사원입니다");
	}
	
	// 이름 입력시 인덱스 반환
	public int getSearchName(String name) {
		int idx = -1;
		for(int i=0; i<employeeList.size(); i++) {
			String listName = employeeList.get(i).getEmployeeName();
			if(listName.equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	// 사원 삭제
	public void deleteEmployee(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1) {
			System.out.println("존재하지 않는 사원입니다");
		} else {
			System.out.println(name + "님의 정보를 삭제했습니다");
			employeeList.remove(idx);
		}
	}
	
	// 사원 검색
	public void searchEmployee(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1) {
			System.out.println("존재하지 않는 사원입니다");
		} else {
			System.out.println("** " + name + "님의 정보입니다 (" + (idx + 1) + "번째) **");
			Employee employee = employeeList.get(idx);
			System.out.println("나이 : " + employee.getAge() + "세");
			System.out.println("연락처 : " + employee.getHp());
			System.out.println("주소 : " + employee.getAddress());
		}
	}
	
	// 사원 목록 출력
	public void writeEmployeeList() {
		System.out.println("\t\t[전체 사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(60));
		
		int n = 0;
		for(Employee s : employeeList) {
			System.out.printf("%d\t%s\t%d세\t%s\t%s\n", ++n, s.getEmployeeName(), s.getAge(), s.getHp(), s.getAddress());
		}
	}



	public static void main(String[] args) {
		Ex1EmployeeArrayList ex1 = new Ex1EmployeeArrayList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
	
		while(true) {
			System.out.println("*** 사원관리 메뉴 ***");
			System.out.println("1. 사원정보추가");
			System.out.println("2. 사원정보검색");
			System.out.println("3. 사원삭제");
			System.out.println("4. 전체사원출력");
			System.out.println("5. 저장 후 종료");
			System.out.print("번호를 선택하세요 : ");
			
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch(NumberFormatException e) {
				menu = 4; // 예외 발생 시 전체 사원 출력
			}
			
			System.out.println("=".repeat(60));
			
			switch(menu) {
			case 1 -> {
				System.out.print("사원 이름 : ");
				String name = sc.nextLine();
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.print("전화번호 : ");
				String hp = sc.nextLine();
				System.out.print("주소 : ");
				String addr = sc.nextLine();
				
				// 사원 객체 생성
				Employee employee = new Employee(name, age, hp, addr);
				// 메서드 호출
				ex1.addEmployee(employee);
				
			}
			case 2 -> {
				System.out.print("사원 이름 : ");
				String name = sc.nextLine();
				ex1.searchEmployee(name);
			}
			case 3 -> {
				System.out.print("사원 이름 : ");
				String name = sc.nextLine();
				ex1.deleteEmployee(name);
			}
			case 4 -> {
				ex1.writeEmployeeList();
			}
			default -> {
				ex1.employeeFileSave();
				System.out.println("사원정보를 파일에 저장 후 종료합니다");
				System.exit(0);	
			}
			}
			System.out.println("=".repeat(60));
		}
	}
}
