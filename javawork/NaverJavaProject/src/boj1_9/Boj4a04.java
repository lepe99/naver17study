package boj1_9;

import java.util.Scanner;

//2562
public class Boj4a04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = 0, max = 0;
		
		
		for(int i=1; i<=9; i++) {
			int n = sc.nextInt();
			if(max < n) {
				max = n;
				idx = i;
			}
			
		}
		sc.close();
		System.out.println(max);
		System.out.println(idx);
		

	}

}
