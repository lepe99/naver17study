package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12 {
//2775
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[k + 1][n + 1];
			
			for(int j=1; j<=n; j++) {
				arr[0][j] = j;
			}
			
			for(int j=1; j<=k; j++) {
				int val = 0;
				for(int l=1; l<=n; l++) {
					val += arr[j - 1][l];
					arr[j][l] = val;
				}
			}
			System.out.println(arr[k][n]);
		}
	}

}
