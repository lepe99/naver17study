package boj1_9;
//10430

import java.util.Scanner;

public class Boj1a09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val1 = sc.nextInt();
		int val2 = sc.nextInt();
		int val3 = sc.nextInt();
		sc.close();
		System.out.println((val1 + val2) % val3);
		System.out.println(((val1 % val3) + (val2 % val3)) % val3);
		System.out.println((val1 * val2) % val3);
		System.out.println(((val1 % val3) * (val2 % val3)) % val3);
		
	}

}