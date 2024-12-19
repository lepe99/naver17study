package day1218;

class Car {
	static String carCompany = "현대";
	
	private String carName;
	private int carPrice;
	
	public static void setCarCompamy(String carCompany) {
		// static 메서드에서는 static 변수로 접근 가능하다!	
		// static 메서드는 클래스가 로드될 때 같이 메모리에 할당 됨
		// 인스턴스 변수들은 해당 객체가 생성될 때 할당 됨
		// 메서드 이용할 때 할당 되지 않은 변수는 사용할 수 없다!
		// 타 객체의 인스턴스 변수를 사용, 수정하지 않는 경우(인스턴스 상태에 의존하지 않는 경우) 메서드를 static으로 선언하는것이 좋다
		
		Car.carCompany = carCompany; // static 변수 호출이기때문에 this ㄴㄴ
	}
	
	// setter method
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	//*
	
	// getter method (값 리턴이 목적이기에 public 해당자료형)
	public String getCarName() {
		return carName; // 이 경우 this 생략 가능
	}
	
	public int getCarPrice() {
		return carPrice;
	}
	//*
	
	public void setData(String carName, int carPrice) {
		this.setCarName(carName);
		this.setCarPrice(carPrice);
	}
}



public class Ex9Object {
	
	public static void writeCarInfo(Car myCar) { // 함수 이용 전에 Car 클래스가 선언되어 있는 상태기에 static사용 괜찮
		// static을 사용하지 않으면 객체를 따로 생성 후 호출해야함
		// static 메서드에서 임의의 인스턴스 메서드 사용할 수 있는 이유 => 새로운 객체를 생성하여 독립적으로 이용하기 때문
		System.out.println("자동차명 : " + myCar.getCarName());
		System.out.println("가격 : " + myCar.getCarPrice());
		System.out.println("=".repeat(30));
	}

	public static void main(String[] args) {
		System.out.println("현재 자동차 회사명 : " + Car.carCompany);
		Car.setCarCompamy("삼성");
		System.out.println("변경된 자동차 회사명 : " + Car.carCompany);
		Car.carCompany = "기아"; // private 아니라 직접 변경 가능, static 변수라 직접 호출 가능
		System.out.println("변경된 자동차 회사명 : " + Car.carCompany);
		
		Car car1 = new Car();
		car1.setCarName("그랜져");
		car1.setCarPrice(3900);
		
		Car car2 = new Car();
		car2.setData("소나타", 3200);
		
		Car car3 = new Car();
		car3.setData("Mini", 5000);
		
//		System.out.println("car1 자동차명 : " + car1.getCarName());
//		System.out.println("car1 가격 : " + car1.getCarPrice());
//		System.out.println("=".repeat(30));
//		System.out.println("car2 자동차명 : " + car2.getCarName());
//		System.out.println("car2 가격 : " + car2.getCarPrice());
		
		writeCarInfo(car1);
		writeCarInfo(car2);
		writeCarInfo(car3);
	}
}
