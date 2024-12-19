package Day1219;

import java.util.StringTokenizer;

// 중요도 낮음
public class Ex9StringTokenizer {

	public static void main(String[] args) {
		String msg = "red|green|yellow|white|black";
//		String msg2 = "red,green,yellow,white,black";
		// | 로 분리해서 출력
//		String[] arr = msg.split("|");
//		for(String a : arr)
//			System.out.println(a); // 잘 안됨
		
		//,로 분리
//		String[] arr2 = msg2.split(",");
//		for(String a : arr2)
//			System.out.println(a); // 잘 됨
		
		StringTokenizer st = new StringTokenizer(msg, "|");
		System.out.println("분리할 총 토큰 수 : " + st.countTokens());
		int len = st.countTokens();
		for(int i=0; i<len; i++) // st.countTokens 는 고정값이 아니기에 for문 조건에 박으면 안됨 // 읽을 때 마다 개수 줄어듦
			System.out.println(st.nextToken()); // 방법 1
		
		System.out.println("=".repeat(20));
		
		StringTokenizer st2 = new StringTokenizer(msg, "|");
		while(st2.hasMoreTokens()) // 토큰이 1개라도 남아있다면 true
			System.out.println(st2.nextToken()); // 방법 2
		
		System.out.println("=".repeat(20));
		
		String[] arr2 = msg.split("|");
		System.out.println("총 " + arr2.length + "개");
		
		String[] arr3 = msg.split("\\|"); // 정규표현식 사용하면 정상 작동. 역슬 두개
		System.out.println("총 " + arr3.length + "개");
		for(String a : arr3)
			System.out.println(a);
		System.out.println();
		
		System.out.println("=".repeat(20));
		
		//아래 데이터를 .으로 분리하여 출력하시오
		String msg3 = "이미자.손태영.강호동.이영자.박진아";
		String[] arr4 = msg3.split("\\.");
		System.out.println("총 " + arr4.length + "개");
		for(String a : arr4)
			System.out.println(a);
	}

}
