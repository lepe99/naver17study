package day1223;
// 매개변수 다형성
class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}

// 추상메서드로도 구현 가능하나, 인터페이스 가능한경우 우선
interface Vehicle {
	public void run();
//	public void run() {
//		System.out.println("차량이 달립니다");
//	}
}

class Bus implements Vehicle { // 인터페이스로 바뀌었으니 extends -> implements
	@Override
	public void run() {
		System.out.println("버스가 달립니다");
	}
}

class Taxi implements Vehicle {
	@Override
	public void run() {
		System.out.println("택시가 달립니다");
	}
}


public class Book320 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		driver.drive(bus);
		
		driver.drive(new Bus()); // 위와 같다
		
		Taxi taxi = new Taxi();
		driver.drive(taxi);
		
		driver.drive(new Taxi());

	}

}
