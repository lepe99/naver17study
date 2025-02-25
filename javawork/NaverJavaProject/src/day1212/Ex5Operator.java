package day1212;

public class Ex5Operator {

	public static void main(String[] args) {
		// 삼항연산자 => 조건 ? 참 : 거짓
		// 조건이 여러 개인 경우 => 조건1 ? 참 : 조건2 ? 참 : 조건3 ? 참 : 거짓
		int x, y, max;
		x = 5;
		y = 13;
		
		max = x > y ? x : y;
		System.out.println("max = " + max);

		int z = 20;
		max = x > y && x > z ? x : y > x && y > z ? y : z;
		System.out.println("max = " + max);
		
		int score = 68;
		char grade;
		// 수식 구현 >=90 : A, >=80 : B, >=70 : C, >=60 : D, else F
		grade = score >= 90 ? 'A' : score >= 80 ? 'B' : score >= 70 ? 'C' : score >= 60 ? 'D' : 'F';
		System.out.printf("%d점은 %c학점입니다\n", score, grade);
		// >=90 : Good else Try
		System.out.println(score + "점은 " + (score >= 90 ? "Good!" : "Try!"));
	}

}
