package day1220;

// 추상 클래스는 자신으로 새로운 객체 생성을 할 수 없다!
// 자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상메서드를 만든다
// 만약 자식 클래스가 추상 메서드를 오버라이드 하지 않았을 경우, 그 클래스도 추상화 시켜야 한다 (abstract)
abstract class Parent2 { 
	// 부모가 process 에서 하는 일이 없을경우
	// 그렇다고 만들지 않으면 자식 클래스에서 오버라이드를 할 수 없다
	// 이 경우 미완성으로 선언만 하는데 이런 경우 abstract 메서드로 만든다 (미완성 메서드란 의미)
	// 추상 클래스에게 상속받은 자식 클래스들의 다형성 처리를 쉽게 할 수 있다
	abstract public void process(); // 추상 메서드는 일반 클래스에 멤버로 올 수 없다 클래스도 추상 클래스여야 함
	// 추상 메서드는 몸체가 없다, 세미콜론 붙이기
	
	// 추상 클래스에 일반 메서드도 구현 가능
	// 부모만 가지고 있는 메서드 만들어보자
	public void study() {
		System.out.println("자바 공부를 한다");
	}
}

class Your1 extends Parent2 {
	@Override
	public void process() {
		System.out.println("벽지 공사를 합니다");
	}
	
	// Your1의 메서드
	public void draw() {
		System.out.println("그림을 그린다");	
	}
	
	
}

class Your2 extends Parent2 {
	@Override
	public void process() {
		System.out.println("타일 공사를 합니다");
	}
	
}

public class Ex6Abstract {
	
	
	public static void yourProcess(Parent2 p) { 
		p.process();
		p.study(); // 부모가 가진 일반 메서드는 호출 가능
//		p.draw(); // 자식이 가진 메서드라 호출 안됨
		((Your1)p).draw(); // 다운캐스팅 후 호출 가능!
		// 하지만 위 방법도 p 에 다른 자식클래스가 할당될 수 있는 경우 오류 발생한다
	}
	
	
	public static void main(String[] args) {
		yourProcess(new Your1());
		System.out.println("=".repeat(30));
//		yourProcess(new Your2()); // 해당 코드 실행 시 다른 자식클래스에만 포함된 메서드 때문 오류 발생
		
//		yourProcess(new Parent2()); // 오류 : 추상 클래스는 new 로 생성할 수 없다
		
	}

}
