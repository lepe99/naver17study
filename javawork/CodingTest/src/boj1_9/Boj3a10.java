package boj1_9;

import java.util.Scanner;

//2439
public class Boj3a10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String vOut = "";
		
		for(int i=1; i<=n; i++) {
			vOut += "*";
			String format1 = String.format("%%%ds\n", n);
			System.out.printf(format1, vOut);
		}
	}
}
