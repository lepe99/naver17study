package day1224;

import java.io.File;

public class Ex2File {

	public static void main(String[] args) {
		File file1 = new File("/Users/lee/naver1210/score.txt");
		File file2 = new File("/Users/lee/naver1210");
			// boolean 타입 반환 파일 메서드들
			System.out.println(file1.length()); // 글자 길이 (byte 단위)
			System.out.println(file1.canExecute()); // 실행 가능한가?	
			System.out.println(file1.canRead()); // 읽기 가능?	
			System.out.println(file1.canWrite()); // 쓰기 가능?
			
			System.out.println(file1.exists()); // 파일 존재 여부
			System.out.println(file1.isDirectory()); // 디렉토리인가? false
			System.out.println(file2.isDirectory()); // true
			
			System.out.println(file1.isFile()); // 파일인가? true
			System.out.println(file2.isFile()); // false
			
			
			// file1이 디렉토리라면 목록을 출력하라
			if(file1.isDirectory()) {
				System.out.println("** file1 목록 **");
				String[] list = file1.list(); 
				// 디렉토리의 목록 출력, 출력 시 String 으로 변환 과정 필요하다
				// System.out.println(file1.list()); 와 같이 쓰면 주소값 출력
				int n = 0;
				for(String s : list)
					System.out.println(++n + " : " + s); 
			} else
				System.out.println("file1은 파일 입니다");
			
			// file2가 디렉토리라면 목록을 출력하라
			if(file2.isDirectory()) {
				System.out.println("** file2 목록 **");
				String[] list = file2.list();
				int n = 0;
				for(String s : list)
					System.out.println(++n + " : " + s);
			} else
				System.out.println("file2은 파일 입니다");
			
			System.out.println("=".repeat(40));
			System.out.println(file1.getAbsolutePath()); // 파일 절대 경로
			System.out.println(file1.getName()); // 파일 경로
			System.out.println(file1.getPath()); // 파일 상대 경로
			// 절대 경로 : 루트 디렉토리부터 시작된 경로 출력
			// 상대 경로 : file 객체 선언 시 설정한 경로
			// 예제에선 두개의 경로가 같다
	}

}
