package boj1_9;

import java.util.Scanner;

//2438
public class Boj3a09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String vOut = "";
		
		for(int i=1; i<=n; i++) {
			vOut += "*";
			System.out.println(vOut);
		}
	}

}
