package day1220;

class SuperObj1 {
	SuperObj1() {
		System.out.println("super 생성자");
	}
	
	SuperObj1(String msg) {
		System.out.println("super 메세지 받는 생성자 : " + msg);
	}
}

class SubObj1 extends SuperObj1 { // SuperObj1 을 상속
	SubObj1() {
		// 여기에 super(); 생략되어있음. 직접 쓸 경우엔 무조건 첫줄에
//		super(); // 부모의 디폴트 생성자를 호출, 생략 가능
		System.out.println("sub 생성자");
	}
	
	SubObj1(String msg) {
		super(msg); // 해당 매개변수 해당하는 부모 생성자 호출, 생략 안됨
		System.out.println("sub의 두번째 생성자");
	}
}




public class Ex1Inherit {
	
	public static void main(String[] args) { 
		SubObj1 sub1 = new SubObj1(); // 생략되어있는 super() 로 인해 부모 클래스의 생성자 먼저 호출
		SubObj1 sub2 = new SubObj1("Hello");
		
	}
}
