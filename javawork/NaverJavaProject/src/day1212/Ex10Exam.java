package day1212;

import java.util.Scanner;

public class Ex10Exam {

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
		
		int sum = cnt >= 5 ? (int) (cnt * price * 0.9) : cnt * price;
		String sale = cnt >= 5 ? "(할인됨)" : "";
		
		System.out.println("상품명 : " + item);
		System.out.println("수량 : " + cnt + "개");
		System.out.println("단가 : " + price + "원");
		System.out.println("총금액 : " + sum + "원 " + sale);
		
	}
}
