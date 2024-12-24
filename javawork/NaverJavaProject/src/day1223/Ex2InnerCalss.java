package day1223;

class OuterObj {
	int a = 10;
	static int b = 20;
	private int c = 30;
	
	class InnerObj {
		int x = 40;
		static int y = 50; // jdk16부터 가능, 이하 버전(jdk15) 에서는 static 선언 불가
		
		public void disp() {
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("c = " + c);
			System.out.println("x = " + x);
			System.out.println("y = " + y); // 내부클래스는 하나의 멤버로 인식하기에 static, private 자유로이 접근 가능
		}
	}
	
	public void outerDisp() { // 내부클래스는 보통 그의 외부클래스에서 직접 호출
		InnerObj inObj = new InnerObj();
		inObj.disp();
	}
}

public class Ex2InnerCalss {

	public static void main(String[] args) {
		OuterObj obj1 = new OuterObj();
		obj1.outerDisp();
		System.out.println();
//		 직접 내부클래스의 메서드를 호출하려면
//		OuterObj.InnerObj obj2 = new OuterObj().new InnerObj();
		OuterObj.InnerObj obj2 = obj1.new InnerObj(); // 이미 외부클래스 호출 변수가 있다면
		obj2.disp();
	}
}
