package solvedAc2;

import java.util.Scanner;

public class Main15 {
//11050
	static int fact(int x) {
		if(x == 1 || x == 0) return 1;
		return fact(x - 1) * x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int val = fact(n) / (fact(k) * fact(n - k));
		
		System.out.println(val);
		
		
	}

}
