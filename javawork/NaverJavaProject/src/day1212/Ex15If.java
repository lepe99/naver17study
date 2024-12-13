package day1212;

import java.util.Scanner;

public class Ex15If {

	public static void main(String[] args) {
		String item;
		int cnt, price;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("상품명 입력");
		item = sc.nextLine();
		System.out.println("수량 입력");
		cnt = sc.nextInt();
		System.out.println("단가 입력");
		price = sc.nextInt();	
		sc.close();
		System.out.println("\n-----------------------\n");
		
		int sum = cnt * price;
		
		System.out.println("상품명 : " + item);
		System.out.println("수량 : " + cnt + "개");
		System.out.println("단가 : " + price + "원");
		System.out.println("총금액 : " + sum + "원 ");
		
		if (cnt >= 5) {
			int dcTotal = (int) (sum * 0.9);
//			int dcTotal = sum * 9 / 10; // 동일
			System.out.printf("\n10프로 DC된 금액은 %d원 입니다", dcTotal);
		}
		

	}

}
