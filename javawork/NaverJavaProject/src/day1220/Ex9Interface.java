package day1220;
/*
 * interface 는 음식점의 메뉴판과 같다. 실체 없이 메뉴 목록만 있기 때문
 * 주문을 해야 음식이 만들어지는 것 처럼 구현을 해야만 기능을 사용할 수 있다
 * interface 에는 추상 메소드와 상수만이 올 수 있다.
 * 이 때, abstract 나 final 은 생략한다
 */
interface InterA {
	public void process();
}

// 인터페이스를 구현하려는 클래스엔 implements 사용
// 인터페이스를 상속받는 다른 인터페이스를 만들 땐 extends 사용, 상속은 한번에 여러 인터페이스 가능

//InterA 구현 클래스
class SubInter implements InterA {

	@Override // 무조건 모든 인터페이스의 메서드를 오버라이드 해야함
	public void process() {
		System.out.println("Sub 클래스의 process");	
	}
}


public class Ex9Interface {
	public static void process(InterA inter) {
		inter.process();
	}
	
	public static void main(String[] args) {
		InterA inter = new SubInter(); // 업캐스팅
		inter.process();
		System.out.println();
		
		//메서드 호출
		process(new SubInter());

	}

}
