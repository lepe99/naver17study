package day1211;

public class Ex9Argument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 Argument 값 읽기 문제");
		System.out.println("------------------------");
		
		String name = args[0];
		String emp = args[1];
		String dep = args[2];
		int score1 = Integer.parseInt(args[3]);
		int score2 = Integer.parseInt(args[4]);
		int score3 = Integer.parseInt(args[5]);
		int total = score1 + score2 + score3;
		float average = total / 3f;
		
		System.out.printf("이름 : %s\n", name);
		System.out.printf("회사명 : %s\n", emp);
		System.out.printf("부서 : %s\n", dep);
		System.out.printf("시험1 : %d점\n", score1);
		System.out.printf("시험2 : %d점\n", score2);
		System.out.printf("시험3 : %d점\n", score3);
		System.out.printf("총점 : %d점\n", total);
		System.out.printf("평균 : %4.1f점\n", average);
	}

}
