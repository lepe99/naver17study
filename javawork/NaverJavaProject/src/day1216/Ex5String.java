package day1216;

public class Ex5String {

	public static void main(String[] args) {
		System.out.println("String 클래스의 멤버 메소드에 대한 공부");
		String str1 = "Apple";
		String str2 = "Have a Nice Day!!";
		String str3 = "Orange";
		String str4 = new String("Apple");
		
		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		System.out.println();
		
		System.out.println("str2의 길이 : " + str2.length());
		System.out.println("str1의 0번 글자 : " + str1.charAt(0));
		System.out.println("str3의 1번 글자 : " + str3.charAt(1));
		System.out.println();
		
		System.out.println("str1에서 l의 위치 : " + str1.indexOf('l'));
		System.out.println("str2에서 a의 위치 : " + str2.indexOf('a')); // 첫번째 1의 위치
		System.out.println("str2에서 마지막 a의 위치 : " + str2.lastIndexOf('a')); // 마지막 1의 위치
		System.out.println("str3에서 x의 위치 : " + str3.indexOf('x')); // 해당 문자가 없으면 -1 발생
		System.out.println();
		
		// 객체 타입에서는 == 연산자가 주소를 비교하는 연산자가 됨
		System.out.println(str1==str4); // f
		System.out.println(str3=="Orange");
		System.out.println(str1=="Apple"); 
		
		// 문자열을 정확하게 비교하기 위해서는 equals() 사용!
		System.out.println(str1.equals(str4)); // t
		System.out.println(str1.equals("apple")); // f 대소문자까지 모두 맞아야 true
		System.out.println(str1.equalsIgnoreCase("apple")); // 
		System.out.println(str1.equalsIgnoreCase("aPPle")); // T 대소문자 상관 없이 철자만 맞으면 ok
		
		System.out.println("문자열 비교 - compareTo");
		int n = str1.compareTo("Apple");
		System.out.println(n); // 0 : 대소문자까지 같을 경우
		
		n = str1.compareTo("Banana"); // -1 / 문자열 작은 값만큼 반환 / 'A', 'B'
		System.out.println(n);
		
		n = str3.compareTo(str1); // Orange, Apple 비교 / 'O', 'A'
		System.out.println(n); // 알파벳 순서가 거꾸로 되어있을경우 양수값 14
		
		System.out.println();
		System.out.println("str2를 모두 대문자로 변환 : " + str2.toUpperCase());
		System.out.println("str2를 모두 소문자로 변환 : " + str2.toLowerCase());
		
		System.out.println();
		System.out.println("str2가 Have로 시작하면 true : " + str2.startsWith("Have")); // t
		System.out.println("str2가 Happy로 시작하면 true : " + str2.startsWith("Happy")); // f
		
		System.out.println("str2가 Day!!로 끝나면 true : " + str2.endsWith("Day!!")); // t
		System.out.println("str2가 Day!로 끝나면 true : " + str2.endsWith("Day!")); // t
		
		System.out.println("=".repeat(50));
		System.out.println(str1.repeat(5)); // 괄호 수량만큼 반복
		
		System.out.println(str2.replace("a", "*"));
		System.out.println(str2.replace("Nice", "Happy")); // 기존 객체 주소, 메모리는 변경 안됨
		
		System.out.println();
		System.out.println(str2.substring(7)); // 7번 인덱스부터 끝까지 추출
		System.out.println(str2.substring(7, 10)); // 7~9까지 추출

		System.out.println("split으로 문자열 분리(배열)");
		String str5 = "red, green, blue, yellow, gray, black";
		System.out.println("str5 = " + str5);
		String[] array = str5.split(", ");
		for(String a : array)	// 배열 출력
			System.out.println(a);
		
		
		System.out.println();
		String str6 = "  Hello     ";
		System.out.println("*" + str6 + "*");
		System.out.println("*" + str6.trim() + "*"); // 앞 뒤 공백제거후 반환
		
		System.out.println();
		System.out.println("String.valueOf : 다양한 타입의 데이터를 String 타입으로 변환");
//		String s1 = String.valueOf(100);
		String s1 = 100 + ""; // int + String = String 간단한 방		
		String s2 = String.valueOf(true);
		String s3 = String.valueOf(34.6);
		String s4 = String.valueOf('A');
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
	}

}
