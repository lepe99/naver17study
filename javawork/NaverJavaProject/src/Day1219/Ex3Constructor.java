package Day1219;
/*
 * 생성자란?
 * 1. 객체 생성 시 자동호출
 * 2. 리턴 타입이 없다 (형식 : [접근지정자] 클래스명)
 * 3. 오버로딩 (OverLoading : 중복함수) 가능
 * 4. 생성자에서는 주로 멤버변수 초기화를 담당한다 (생성할 때만 호출 가능, 이외의 경우엔 setter 사용)
 */

class Apple { // 하나의 자바 파일에 하나의 퍼블릭 클래스만 있어야 한다
	Apple() { // 생성자의 이름은 클래스의 이름과 동일해야 한다
		System.out.println("디폴트 생성자");
	}
	
	Apple(String name) {
		System.out.println(name + "을 인자로 받음");
	}
	
	Apple(int age) {
		System.out.println(age + "를 인자로 받음");
	}
	
	Apple(String name, int age) {
		System.out.println(name+ "과 " + age + "를 인자로 받음");
	}
}

public class Ex3Constructor { // 생성자

	public static void main(String[] args) {
		Apple a1 = new Apple(); // 생성자 자동 호출
		Apple a2 = new Apple("강씨");
		Apple a3 = new Apple(40);
		Apple a4 = new Apple("빨강", 23);
	}
}
