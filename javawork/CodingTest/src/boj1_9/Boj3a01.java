package boj1_9;

import java.util.Scanner;

//2739
public class Boj3a01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.close();
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n * i);
		}
		
	}

}
