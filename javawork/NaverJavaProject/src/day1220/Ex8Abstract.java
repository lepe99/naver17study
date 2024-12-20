package day1220;

abstract class Test1 {
	abstract public void play();
}

abstract class Test2 extends Test1 {
	// 추상화 시키던가, 메서드 오버라이드 하던가 해야 함
	abstract public void job();
}

class Test3 extends Test2 {
	@Override
	public void play() {
		System.out.println("play");
	}
	@Override
	public void job() {
		System.out.println("job");
		
	}
	
}

public class Ex8Abstract {
	public static void hello1(Test1 t1) {
		// 호출 가능한 메서드들을 찾아보자
		t1.play();
//		t1.job();
		System.out.println();
	}
	
	public static void hello2(Test2 t2) {
		// 호출 가능한 메서드들을 찾아보자
		t2.play();
		t2.job();
		System.out.println();
	}
	

	public static void main(String[] args) {
		hello1(new Test3()); // 조부 메서드 (Test1) 에는 job 메서드에 대한 구현이 없다
		hello2(new Test3());

	}

}
