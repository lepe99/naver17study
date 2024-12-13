package day1211;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor = 90;
		int eng = 93;
		System.out.println("합계 = " + kor + eng);
		//String 과 int 의 연산 : 묵시적 형 변환에 의해 String으로 출력
		System.out.println("합계 = " + (kor + eng));//괄호로 연산 순서 변경
		
		//진법 변환
		int a = 056; //8진수 
		int b = 0x12a; //16진수 
		int c = 0b1011; //2진수 
		int d = 047; 
		int e = 0xA9; 
		System.out.println("a = " + a);//5*8^1 + 6*8^0 = 46
		System.out.println("b = " + b);//1*16^2 + 2*16^1 + 10*16^0 = 298
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);

	}

}
