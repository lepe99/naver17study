package day1223;

import java.io.FileWriter;
import java.io.IOException;

public class Ex11Exception {

	public static void main(String[] args) {
		// 일반 Exception 은 선택이 아니라 필수로 처리해야만 한다 (이유 : 컴파일 상에서 오류가 발생한다)
		// 메서드 자체를 throws 로 던지는 Exception 처리하면 됨
		System.out.println("3초만 기다리세요");
		
		try {
			Thread.sleep(3000); // 빨간줄에 cmd + 1 누르면 해결방안 단축
			// 실행중인 스레드를 3초 중지시킴
			// 사용시 반드시 예외처리
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("오래 기다리셨어요");
		
		// 파일에 이름과 주소를 저장해보자
		FileWriter fw = null;
		try {
//			fw = new FileWriter("/Users/lee/naver1210/memo.txt"); // 새로 생성, 이미 파일이 있으면 덮어씀
			fw = new FileWriter("/Users/lee/naver1210/memo.txt", true); // 이미 파일이 있다면 기존 파일에 추가
			fw.write("이름 : 강호동\n");
			fw.write("주소 : 서초구\n");
			fw.write("============\n");
			System.out.println("탐색기로 파일을 확인하세요");
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				fw.close(); // FileWriter 닫아주기, 사용 / 닫기 모두 예외처리
			} catch (IOException | NullPointerException e) { 
				// fw 생성시 오류가 발생했을 때, fw = null 일 때 대비한 처리 같이 넣어주기
				e.printStackTrace();
			}
			
		}
		System.out.println("정상 종료");

	}

}
