package day1219;

public class Ex10MyCarArray {
	public static void showTitle() {
		System.out.println("자동차명\t가격\t색상\t구입일");
		System.out.println("=".repeat(50));
	}
	
	public static void writeMyCar(MyCar myCar) {
		System.out.print(myCar.getCarName() + "\t");
		System.out.print(myCar.getCarPrice() + "\t");
		System.out.print(myCar.getCarColor() + "\t");
		System.out.print(myCar.getPurchaseDay() + "\t");
		System.out.println();
	}

	public static void main(String[] args) {
		MyCar my1 = new MyCar();
		System.out.println(my1); // toString이 있을 경우 자동 호출, 없을 시 주소 호출	
		//String 형식이 없는 개체를 임의의 String 형식 지정해서 표현 가능
		
		MyCar my2 = new MyCar("소나타", 3900, "진주색");
		System.out.println(my2);
		
		// 방법 1
//		System.out.println("객체 배열 생성");
//		MyCar[] carArray = {
//				new MyCar(),
//				new MyCar("그랜져", 5600, "검정색"),
//				new MyCar("BMW", 6700, "흰색")
//		};
			
		// 방법 2
		MyCar[] carArray = new MyCar[3]; // 메모리할당, 초기값 null
		carArray[0] = new MyCar();
		carArray[1] = new MyCar("그랜져", 5600, "검정색");
		carArray[2] = new MyCar("BMW", 6700, "흰색");
	
		
		//제목 출력
		showTitle();
		
		// for문으로 데이터 출력
//		for(MyCar my : carArray)
//			writeMycar(my);
	
		for(int i=0; i<carArray.length; i++)
			writeMyCar(carArray[i]);
	};	

	

}
