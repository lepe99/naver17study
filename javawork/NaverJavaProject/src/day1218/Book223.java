package day1218;

public class Book223 {

	public static void main(String[] args) {
		Korean kor1 = new Korean("박자바", "011225-1234567");
//		Korean kor = new Korean(); // 별도 생성자 선언 시 기본생성자 못씀, 쓰고싶으면 오버로딩 하기
		
		System.out.println(kor1.nation);
		System.out.println(kor1.name);
		System.out.println(kor1.ssn);
		
		System.out.println("=".repeat(30));
		
		Korean kor2 = new Korean("김바자", "930225-7654321");
		
		System.out.println(kor2.nation);
		System.out.println(kor2.name);
		System.out.println(kor2.ssn);

	}
//
}
