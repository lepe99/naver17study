package day1220;

import day1220_2.Apple;

class Orange extends Apple {
	public void play() {
		this.job();
		this.study();
//		this.draw(); // 오류 발생, default 로 선언된 메서드라 상속관계더라도 접근 불가
		this.process(); // 현재 클래스의 오버라이드 메서드가 호출
	}
	
	@Override
	protected void process() {
//	public void process() { // 더 넓은 범위인 public 은 허용, default, private 는 오류 발생
		super.process();
		System.out.println("Oracle, Mysql 공부를 더 깊게 합니다");
	}
}


public class Ex4Inherit {

	public static void main(String[] args) {
		Orange or = new Orange();
		or.play();

	}

}
