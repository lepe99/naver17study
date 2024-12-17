package day1217;

public class Book124 {

	public static void main(String[] args) {
		char grade = 'B';
		
//		switch(grade) {
//		case 'A', 'a' -> {
//			System.out.println("우수");
//		}
//		case 'B', 'b' -> {
//			System.out.println("일반");
//		}
//		default -> {
//			System.out.println("손님");
//		}
//		}
		// 한문장씩이라 괄호 생략 가능
		switch(grade) {
		case 'A', 'a' -> System.out.println("우수");
		case 'B', 'b' -> System.out.println("일반");
		default -> System.out.println("손님");
		}
		
		//람다
		

	}

}
