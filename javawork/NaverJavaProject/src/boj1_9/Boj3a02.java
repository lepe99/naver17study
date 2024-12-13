package boj1_9;

import java.util.Scanner;

//10950
public class Boj3a02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.close();
		
		for (int i=0; i<t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a + b);
		}
	}

}
