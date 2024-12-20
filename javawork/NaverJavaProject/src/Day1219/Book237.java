package day1219;

public class Book237 {

	public static void main(String[] args) {
		Computer myCom = new Computer();
		
		int res1 = myCom.sum(1, 2, 3);
		System.out.println("res1 = " + res1);
		
		int res2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("res2 = " + res2);
		
		int[] values = {1, 2, 3, 4, 5};
		int res3 = myCom.sum(values); // 배열 직접 넣을 수 있음!
		System.out.println("res3 = " + res3);
		
		int res4 = myCom.sum(new int[] {1, 2, 3, 4, 5}); // 즉석 생성 가능 	
		System.out.println("res4 = " + res4);

	}

}
