package day1223;
// 매개변수 다형성
class Driver {
	public void drive(Vehicle vehicle) {
		vehicle.run();
	}
}

class Vehicle {
	public void run() {
		System.out.println("차량이 달립니다");
	}
}

class Bus extends Vehicle {
	@Override
	public void run() {
		System.out.println("버스가 달립니다");
	}
}

class Taxi extends Vehicle {
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
