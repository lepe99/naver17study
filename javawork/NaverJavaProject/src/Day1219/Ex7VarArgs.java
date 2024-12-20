package day1219;

public class Ex7VarArgs {
	
	
	public static int calcNum(int ... n) {
		int  sum = 0;
		System.out.println("총 " + n.length + "개의 점수");
		
		for(int score : n) {
			System.out.print(score + " ");
			sum += score;
		}
		System.out.println();
		return sum;
	}
	
	
	public static void main(String[] args) {
		int s1 = calcNum(90, 80);
		System.out.println("합계 = " + s1); 
		
		int s2 = calcNum(90, 80, 60);
		System.out.println("합계 = " + s2); 
		
		int s3 = calcNum(90, 80, 60, 45, 32, 28, 74);
		System.out.println("합계 = " + s3); 

	}

}
