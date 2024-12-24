package day1223;

interface InterA {
	public void study();
}
// 인터페이스 끼리의 상속은 extends
interface InterB extends InterA {
	public void play();
}

// 클래스가 인터페이스 구현 시 implements
class MyInter implements InterB {
	@Override
	public void study() {
		System.out.println("그룹 스터디를 합니다");
	}
	
	@Override
	public void play() {
		System.out.println("그룹 모임을 합니다");
	}
	
	public void job() {
		System.out.println("밀린 일처리를 합니다");
	}
}

public class Ex1InterfaceInherit {

	public static void main(String[] args) {
		InterA interA = new MyInter();
		interA.study(); // play 호출 불가
		((MyInter) interA).play();
		((MyInter) interA).job(); // 2분위 아래도 다운캐스팅 가능
		System.out.println("=".repeat(20));
		
		InterB interB = new MyInter();
		interB.study();
		interB.play();
		// 다운캐스팅 해보기
		((MyInter) interB).job(); // 다운캐스팅으로 호출 가능
		System.out.println("=".repeat(20));
		
		MyInter my = new MyInter();
		my.study();
		my.play();
		my.job(); // 상속 관계에 따라 호출할 수 있는 메서드가 달라진다
	}
}
