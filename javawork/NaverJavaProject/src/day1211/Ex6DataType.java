package day1211;

public class Ex6DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String은 기본형 아니고 객체 타입이다.
		String str1 = "Hello";
		String str2 = new String("Happy");//new는 새로운 객체 생성 역
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("\t" + str1);
		System.out.println("\t\t" + str2);
		
		//printf에서 문자열의 변환기호는 %s
		System.out.printf("%s\n", str1);
		System.out.printf("%30s\n", str1);
		System.out.printf("%40s\n", str1);
		System.out.printf("**%-30s**\n", str1);
		
		//문자열에서 + 연산자는 나열을 의미한다 (다른 사칙연산들은 문자열에서 x)
		System.out.println(str1 + str2);
		
	}

}
