package boj1_9;

import java.util.Scanner;

public class Boj2a01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		String ans = a > b ? ">" 
			: a < b ? "<"
			: "==";
		
		System.out.println(ans);

	}

}
