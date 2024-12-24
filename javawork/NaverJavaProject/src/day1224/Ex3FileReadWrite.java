package day1224;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3FileReadWrite {
	static final String FILENAME = "/Users/lee/naver1210/member.txt"; // 파일 경로 고정값 설정
	
	
	public static void fileRead() throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			// 제목
			System.out.println("\t전체 멤버 명단");
			System.out.println();
			System.out.println("번호\t이름\t나이\t주거지");
			System.out.println("=".repeat(35));
			
			int n = 0;
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				
				// , 로 줄의 내용 분리하기
				String[] m = line.split(", "); // 데이터의 양식은 "이름, 나이, 주거지"
				System.out.printf("%d\t%s\t%s세\t%s\n", ++n, m[0], m[1], m[2]);
		
			}
		} catch (FileNotFoundException e) { // Read 작업 시 반드시 예외 처리
			System.out.println("** 해당 파일을 찾을 수 없습니다 **");
		} finally {
			if(fr != null) fr.close();
			// NullPointerException 예외 처리를 하거나, if 문 처리
			if(br != null) br.close();
		}
	}
	
	
	
	public static void fileSave() throws IOException {
		FileWriter fw = null;
		Scanner sc = new Scanner(System.in);
		String name, age, addr;
		
		fw = new FileWriter(FILENAME, true); // f : 덮어쓰기, t : 추가
		
		// 추가할 데이터 입력
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("나이 : ");
		age = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();
			
		// 파일에 추가
		fw.write(name + ", " + age + ", " + addr + "\r"); 
		// 윈도우 환경에선 \n 으로 개행 되지만 맥 텍스트 편집기에선 \r 로 캐리지 리턴
		
		// 파일 닫기
		if(fw != null) fw.close();
		System.out.println("추가되었습니다");
	}
	
	
	
	
	public static void fileDelete() throws IOException {
		// 파일 삭제
		File file = new File(FILENAME);
		if(file.exists()) {
			System.out.println("파일을 삭제합니다"); 
			file.delete(); // 모든 멤버 삭제
		} else
			System.out.println("삭제할 파일이 없습니다");
		
		System.out.println();
	}
	
	
	
	
	public static int getMenu() {
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("=".repeat(35));
		System.out.println();
		System.out.println("1. 멤버추가 2. 전체출력 3. 전체멤버삭제 4. 종료");
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			menu = 2; // 메뉴에 문자가 들어올 경우 전체 출력으로 처리하겠다
		}
		return menu;
	}
	
	public static void main(String[] args) throws IOException { 
		// main 에서 IOException 을 throws 하여 예외 처리를 하지 않는다
		
		while(true) {
			switch(getMenu()) {
			case 1 : {
				fileSave();
				break;
			}
			case 2 : {
				fileRead();
				break;
			}
			case 3 : {
				fileDelete();
				break;
			}
			default : {
				System.out.println("프로그램을 종료합니다");
				System.exit(0); // 시스템 정상 종료
			}
			}
		}
		

	}

}
