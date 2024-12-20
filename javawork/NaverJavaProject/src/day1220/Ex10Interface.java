package day1220;

interface InterB {
	int SPEED = 100; // 상수는 대문자로 선언!, final 생략됨
	public void speedWrite();
	public void speedUp(int speed);
	public void speedDown(int speed);
}

class Car implements InterB {
	
	int curSpeed = SPEED; // 상수로 초기값 대입하기
	@Override
	public void speedWrite() {
//		System.out.println("현재 속도는 " + SPEED); // 변화 반영 못함
		System.out.println("현재 속도는 " + curSpeed);
		
	}

	@Override
	public void speedUp(int speed) {
//		SPEED += speed; // SPEED는 상수이므로 변경 불가!
		System.out.println("속도를 " + speed + " 올립니다");
		curSpeed += speed;
		
	}

	@Override
	public void speedDown(int speed) {
		System.out.println("속도를 " + speed + " 내립니다");
		curSpeed -= speed;
		
	} // 왼쪽 경고표나 Source 들어가서 메소드 오버라이드 하기
	
}

public class Ex10Interface {

	public static void main(String[] args) {
		InterB inter = new Car();
		inter.speedWrite();
		inter.speedUp(30);
		inter.speedWrite();
		inter.speedDown(50);
		inter.speedWrite();

	}

}
