package day1212;

import java.util.Scanner;

public class Ex8Scanner {

	public static void main(String[] args) {
		// nextInt nextLine 혼용 힘듬. nextLine이 nextInt가 남긴 버퍼인 개행문자를 읽어오기 때문
		Scanner sc = new Scanner(System.in);
		String item;
		int price;
		
		System.out.println("상품 가격 입력");
		price = sc.nextInt(); // 숫자만 읽고 엔터는 버퍼로 들어간다
		sc.nextLine(); // 버퍼 엔터 가져가
		System.out.println("상품명 입력");
		item = sc.nextLine(); // 버퍼의 엔터를 읽어온다 (없을 경우 키보드로부터 들어온다)
		sc.close();
		System.out.println(item + "의 가격은 " + price + "원 입니다");
	}

}