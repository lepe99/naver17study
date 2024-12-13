package boj1_9;
//9498
import java.util.Scanner;

public class Boj2a02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.close();
		
		System.out.println(score >= 90 ? 'A'
						: score >= 80 ? 'B'
						: score >= 70 ? 'C'
						: score >= 60 ? 'D' : 'F');

	}

}
