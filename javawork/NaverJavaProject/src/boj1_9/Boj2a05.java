package boj1_9;

import java.util.Scanner;

//2884
public class Boj2a05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		int ansH = m - 45 >= 0 ? h : h == 0 ? 23 : h - 1;
		int ansM = m - 45 >= 0 ? m - 45 : m + 15;
		
		System.out.printf("%d %d", ansH, ansM);

	}

}
