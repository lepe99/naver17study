package day1212;

public class Ex4Operator {

	public static void main(String[] args) {
		// 관계(>, <, >=, <=, ==), 논리연산자 (&&, ||, !, 결과값 true or false(boolean))
		int kor = 89, eng = 100, mat = 89; // 각각 선언하며 대입 가능
		boolean f = false;
		
		System.out.println(kor > eng); // f
		System.out.println(kor < eng); // t
		System.out.println(kor == mat); // t
		System.out.println(kor != mat); // f
		System.out.println(kor > eng && ++eng > mat); // f and t => f
		System.out.println(eng);
		System.out.println(kor > eng || ++eng > mat); // f or t => t
		// &&, || 과 같은 논리 연산자는 &, |와 달리 첫번째 피연산자로 판별이 가능하다면 두번째 피연산자를 평가하지 않는다.
		// &&, || 가 더 효율성도 좋고 NullPointerException를 방지하여 안정성이 높기 때문에 &, |는 비트 연산에서만 사용.
		System.out.println(eng); // 1 증가
		System.out.println(!(kor > eng));
		System.out.println(!f);

		
	}

}
