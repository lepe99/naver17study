package boj1_9;

import java.util.Scanner;

//8393
public class Boj3a03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		int sum = 0;
		
		for(int i=1; i <= n; i++) sum += i;
		System.out.println(sum);
		
	}

}
