package boj1_9;

import java.util.Scanner;

//2525
public class Boj2a06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int ansH = (a + (b + c) / 60) % 24;
		int ansM = (b + c) % 60;
		System.out.printf("%d %d", ansH, ansM)
		;
	}

}
