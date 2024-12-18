package day1218;

public class Ex6Object {
	static int x = 10; // static 변수는 인스턴스변수 없이도 접근이 가능하다
	static int y = 20;
	
	//매서드도 static 만들어보기
	public static void showTitle() {
		System.out.println("클래스 공부중...");
		System.out.println("static 변수는 접근 가능 : " + x + ", " + y);
	}
	
	public static void main(String[] args) {
		System.out.println("x = " + Ex6Object.x); // static 변수는 클래스명으로 접근
		System.out.println("x = " + x); // 같은 클래스 멤버일 경우 클래스명 생략 가능
		
		// static 변수 x와 y를 더해보자
		int sum = x + y;
		System.out.println("sum = " + sum);
		
		// static 매서드 호출
		Ex6Object.showTitle();
		showTitle(); // 같은 클래스 멤버일 경우 클래스명 생략 가능


	}

}
