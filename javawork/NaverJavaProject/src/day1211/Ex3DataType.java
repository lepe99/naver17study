package day1211;

public class Ex3DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float f1 = 3.6f;//float 저장시 무조건 뒤에 f를 붙여야 함. 아니면 double로 인식.
		double f2 = 5.6;
		
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		
		float f3 = 2.123456789f;
		double f4 = 2.123456789;
		
		System.out.println("f3 = " + f3);//float의 유효 소수 이하 자리는 7자리
		System.out.println("f4 = " + f4);//double의 유효 소수 이하 자리는 15자리
	
		//printf : jdk5 부터 추가된 기능, 변환기호를 이용한 출력문
		//실수형 %f 정수형 %d 문자열 %s
		//제어 문자열(이스케이프 문자) : \n(줄넘김), \t(탭), \\(\), \"(") 등등
		System.out.printf("f3 = %f\nf4 = %f\n\n", f3, f4);//변환기호 갯수만큼 변수명 나열
		System.out.printf("f3 = %5.1f\nf4 = %5.2f\n\n", f3, f4);//%5.1f : 전체 자릿수 5, 소숫점 자릿수 1
	}

}
