package boj1_9;

import java.util.Scanner;

//25304
public class Boj3a04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum += a * b;
		}
		sc.close();
		System.out.println(x == sum ? "Yes" : "No");
	}	

}
