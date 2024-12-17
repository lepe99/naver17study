package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
//2839
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		 dp
		
//		int[] dp = new int[5001];
//		Arrays.fill(dp, 987654321);
//		dp[3] = 1;
//		dp[5] = 1;
//		
//		for (int i=6; i<=n; i++) {
//			dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
//		}
//		
//		if(dp[n]>1000000) System.out.println(-1);
//		else System.out.println(dp[n]);

		// 그리디
		
		for(int i=0; i<=n/3; i++) {
			for(int j=0; j<=n/5; j++) {
				if(j * 5 + i * 3 == n) {
					System.out.println(i + j);
					return;
				} 
			}
		}
		System.out.println(-1);
	
		
		
	}
}
