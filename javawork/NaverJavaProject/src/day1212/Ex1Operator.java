package day1212;

public class Ex1Operator {

	public static void main(String[] args) {
		//증감 연산자, ++변수 (전치, 1순위), 변수++ (후치 : 끝순위)
		int a, b, m, n; //자바도 다중 선언 가능, 다중 선언 동시 대입은 불가
		a = b = 5;
		m = ++a;//a 증가 후 m 대입
		n = b++;//n 증가 후 n 대입
		System.out.printf("a = %d, b = %d, m = %d, n = %d\n", a, b, m ,n);
		
		a = b = m = n = 5;
		m = a++ * ++b;//5 * 6
		n = a++ + ++b; //띄어쓰기 주의, 6 + 7
		System.out.printf("a = %d, b = %d, m = %d, n = %d\n", a, b, m ,n);
		
		a = 5;
		System.out.println(a++);//후위 수식하면 출력 후 증감 적용, 5출력 후 1증가
		System.out.println(++a);//증가 후 출력 6에서 1증가 후 7 출력
		
		a = b = m = n = 5;
		a *= b-- - ++n * 3; // b--는 a에 값 대입 이후에 감소한다
		System.out.printf("a = %d, b = %d, m = %d, n = %d\n", a, b, m ,n);
		
	}

}
