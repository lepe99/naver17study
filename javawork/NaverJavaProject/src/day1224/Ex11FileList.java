package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex11FileList {
	static final String FILENAME = "/Users/lee/naver1210/ex11.txt";
	List<String> employeeList = new Vector<>();
	
	
	// 생성자
	public Ex11FileList() {
		// 파일에서 이름을 읽어 employeeList에 추가해주세요
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) 
					break;
				employeeList.add(line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다 : " + e.getMessage());
			
		} catch (IOException e) {
			e.printStackTrace();
			
			// FileNotFoundException 은 IOException 을 상속하는 예외 클래스이므로
			// FileNotFoundException 을 먼저 예외 처리 하여야 한다
			
		} finally {
			try {
				br.close();
				fr.close(); // 닫기 서순
			} catch (IOException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 메서드
	public void employeeMemberList() {
		// 사원 이름을 번호와 함께 출력 해 주세요
		System.out.println("총 " + employeeList.size() + "명의 사원이 있습니다");
		System.out.println("번호\t사원명");
		System.out.println("=".repeat(30));
		// #1
		for(int i=0; i<employeeList.size(); i++) 
			System.out.printf("%d\t%s\n", i + 1, employeeList.get(i));
		
		System.out.println("=".repeat(30));
		// #2
//		Iterator<String> iter = employeeList.iterator();
//		int n = 0;
//		while(iter.hasNext())
//			System.out.printf("%d\t%s\n", ++n, iter.next());
	}
	
	
	// 해당 이름이 몇번 인덱스에 있는지 리턴 (없으면 -1 리턴)
	public int getSearchName(String name) {
		int idx = -1;
		for(int i=0; i<employeeList.size(); i++) {
			String listName = employeeList.get(i);
			if(listName.equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}
		
	
	// 이름 입력 시 삭제
	public void deleteEmployee(String name) {
		int idx = this.getSearchName(name); // this 생략 무방
		if (idx == -1)
			System.out.println(name + "님은 사원 명단에 없습니다");
		else {
			employeeList.remove(idx);
			System.out.println(name + "님을 사원 명단에서 삭제했습니다");
		}
	}
	
	
	// 이름 조회
	public void searchName(String name) {
		int idx = this.getSearchName(name);
		if(idx == -1)
			System.out.println(name + "님은 사원 명단에 없습니다");
		else
			System.out.println(name + "님은 " + (idx + 1) + "번째에 있습니다");
	}
	
	
	// List 의 이름들을 다시 파일에 저장하기
	public void employeeFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for(String name : employeeList)
				fw.write(name + "\r");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) { // NullPointerException 넣을 필요 없음
				e.printStackTrace();
			}
		}
	}
	
	
	// 사원명 추가
	public void addEmployee(String name) {
		// 이미 존재할 경우 추가 못하게
		int idx = this.getSearchName(name);
		if(idx != -1)
			System.out.println(name + "님은 이미 존재합니다");
		else {
			employeeList.add(name);
			System.out.println("추가 되었습니다");
		}
	}
	
	
	public static void main(String[] args) {
		Ex11FileList ex11 = new Ex11FileList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		while(true) {
			System.out.println("0. 사원목록 / 1. 사원추가 / 2. 사원삭제 / 3. 사원검색 / 4. 저장후종료");
			System.out.println("=".repeat(40));
			
			try {
				menu = Integer.parseInt(sc.nextLine()); // 정수 입력 아닐 시 사원목록 출력
			} catch(NumberFormatException e) {
				menu = 0;
			}
			
			switch(menu) {
			case 0 -> {
				ex11.employeeMemberList();
			}
			case 1 -> {
				System.out.print("추가할 사원명을 입력 : ");
				String name = sc.nextLine();
				ex11.addEmployee(name);
			}
			case 2 -> {
				System.out.print("삭제할 사원명을 입력 : ");
				String name = sc.nextLine();
				ex11.deleteEmployee(name);
			}
			case 3 -> {
				System.out.print("검색할 사원명을 입력 : ");
				String name = sc.nextLine();
				ex11.searchName(name);
			}
			default -> {
				System.out.print("** 저장 후 종료 **");
				ex11.employeeFileSave();
				System.exit(0);
			}
			}
			
		}
	

	}

}
