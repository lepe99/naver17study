package day1223;

import java.util.Date;

public class Ex7Exception {

	public static void main(String[] args) {
		int[] arr = {4, 5, 7 ,12};
		
		for(int i=0; i<=arr.length; i++) { // 예외 발생! ArrayIndexOutOfBoundsException
			try {
				System.out.println(arr[i]);
			} catch (ArrayIndexOutOfBoundsException e) { // 예외 처리
//			} catch (Exception e) { // 모든 예외 처리
				System.out.println("오류메세지 : " + e.getMessage()); // 예외 발생 이유 리턴
				System.out.println();
				System.out.println(e.toString()); // 예외의 종류 리턴
				System.out.println();
				e.printStackTrace(); // 오류 추적을 하여 행번호까지 표시
			} 
		}
		
		System.out.println();
		System.out.println();
		
		
		Date date = null; // NullPointerException
		try {
			int age = (date.getYear() + 1900) - 1989;
			System.out.println("age = " + age);
		} catch (NullPointerException e) {
			System.out.println("오류메세지 : " + e.getMessage());
		}
		
		
		System.out.println("정상종료");

	}

}