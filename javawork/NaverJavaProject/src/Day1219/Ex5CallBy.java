package day1219;

/*
 * 인자전달방식
 * CallByValue : 값만 전달(기본형, String)	
 * CallByReference : 주소가 전달 (모든 객체, 배열타입)
 */
class Test {
	String message;
	int code;
}
///////////////////////////
public class Ex5CallBy {
	
	public static void changeInt(int n) { // 주소가 다르게 새로 생성
		n = 200;
	}
	
	public static void changeString(String s) { // 주소가 다르게 새로 생성
		s = "apple";
	}
	
	public static void changeTest(Test t) {
		t.message = "Happy";
		t.code = 100;
	}
	
	public static void changeArray(int[] arr) {
		arr[1] = 20;
	}

	public static int changeScore(int score) {
		if(score >= 80) return score;
		else return 90;
	}
	
	public static void main(String[] args) {
		int n = 100;
		changeInt(n);
		System.out.println("n = " + n); // 값만 전달 (value)
		
		String s = "berry";
		changeString(s);
		System.out.println("s = " + s); // 값만 전달
		
		Test t = new Test();
		System.out.println("message : " + t.message);
		System.out.println("code : " + t.code);
		changeTest(t); // 주소가 전달!
		System.out.println("message : " + t.message);
		System.out.println("code : " + t.code);
		
		//배열
		int[] a = {5, 8, 11}; // 레퍼런스 타입	. 배열은 무조건 객체로 인식 (reference)
		changeArray(a); // 주소가 전달
		for(int aa : a)
			System.out.print(aa + " ");
		System.out.println();
		
		int score = 80;
		// 값만 전달되는 경우는 메서드에서 변경된 값을 받으려면
		// 리턴으로 받아와야 한다 (return x;)
		score = changeScore(score);
		System.out.println("score = " + score);
	}

}
