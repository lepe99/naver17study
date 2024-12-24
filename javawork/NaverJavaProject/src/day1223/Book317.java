package day1223;
// 필드 다형성
class Car {
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
}

class Tire {
	public void roll() {
		System.out.println("회전합니다");
	}
}

class HankookTire extends Tire {
	@Override
	public void roll() {
		System.out.println("한국 타이어가 회전합니다");
	}
}

class KumhoTire extends Tire {
	@Override
	public void roll() {
		System.out.println("금호 타이어가 회전합니다");
	}
}

public class Book317 {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.tire = new Tire();
		myCar.run();
		
		myCar.tire = new HankookTire();
		myCar.run();
		
		myCar.tire = new KumhoTire();
		myCar.run();
		

	}

}
