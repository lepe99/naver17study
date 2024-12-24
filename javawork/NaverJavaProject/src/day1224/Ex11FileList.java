package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
			
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
			
			// FileNotFoundException 은 IOException 을 상속하는 예외 클래스이므로
			// FileNotFoundException 을 먼저 예외 처리 하여야 한다
			
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 메서드
	public void employeeMemberList() {
		// 사원 이름을 번호와 함께 출력 해 주세요
		// #1
		for(int i=0; i<employeeList.size(); i++) 
			System.out.printf("%d : %s\n", i + 1, employeeList.get(i));
			
		System.out.println("=".repeat(40));
		// #2
		Iterator<String> iter = employeeList.iterator();
		int n = 0;
		while(iter.hasNext())
			System.out.printf("%d : %s\n", ++n, iter.next());
		
		
	}
	public static void main(String[] args) {
		Ex11FileList ex11 = new Ex11FileList();
		ex11.employeeMemberList();
	

	}

}
