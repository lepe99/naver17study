package day1212;

public class Ex2Operator {

	public static void main(String[] args) {
		// 산술 연산자 + - * / %
		
		int a = 10;
		int b = 10;
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b); // 몫 (묵시적 형변환에 의해 결과가 int 타입으로 출력되기 때문)
		System.out.println((double) a / b); // 정확한 나눗셈 double 타입	
		System.out.println(a % b); // 나머지 
		System.out.println("----------------------");
		int money = 3456789;
		System.out.println("금액 : " + money + "원");
		System.out.println("만원 : " + money / 10000 + "장");
		System.out.println("천원 : " + money % 10000 / 1000 + "장");
		System.out.println("백원 : " + money % 1000 / 100 + "개");
		System.out.println("십원 : " + money % 100 / 10 + "개");
		System.out.println("일원 : " + money % 10 + "개");
	}

}
