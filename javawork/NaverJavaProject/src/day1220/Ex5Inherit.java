package day1220;

class Parent1 {
	public void process() {
		System.out.println("기본 작업을 한다");
	}
}

class My1 extends Parent1 {
	@Override
	public void process() {
		super.process();
		System.out.println("벽지 작업을 한다");
	}
	
}

class My2 extends Parent1 {
	@Override
	public void process() {
		super.process();
		System.out.println("바닥 작업을 한다");
	}
	
}

public class Ex5Inherit {
	
	public static void homeProcess(My1 my) {
		my.process();
	}
	
	public static void homeProcess2(My2 my) {
		my.process();
	}
	
	
	public static void homeProcessAll(Parent1 p) { // 다형성 처리. 자기 자신, 자식들 모두 가능
		p.process(); // p 안에 누가 생성되어있느냐에 따라 서로 다른 일을 처리한다
	}
	
	
	
	public static void main(String[] args) {
		My1 my1 = new My1();
		My2 my2 = new My2();
		
//		my1.process();
//		my2.process();
		
		homeProcess(my1);  // my2 는 불가
		homeProcess2(my2); 
		System.out.println("=".repeat(20));
		
		// 하나로 하고 싶으면 -> 다형성 처리
		Parent1 p1 = null;
		p1 = new My1();
		p1.process(); // my1이 가진 process 메서드 호출
		
		p1 = new My2();
		p1.process(); // my2가 가진 process 메서드 호출
		System.out.println("=".repeat(20));
		
		homeProcessAll(new My1());
		homeProcessAll(new My2());
		homeProcessAll(new Parent1()); // 다형성 처리. 반드시 오버라이드가 되어야 한다!
		
		
		
	}

}
