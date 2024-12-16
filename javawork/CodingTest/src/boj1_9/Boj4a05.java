package boj1_9;

import java.util.Arrays;
import java.util.Scanner;

//10810	
public class Boj4a05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n + 1];
		
		for(int i=1; i<=m; i++) {
			String[] val = sc.nextLine().split(" ");
			int a = Integer.parseInt(val[0]);
			int b = Integer.parseInt(val[1]);
			int c = Integer.parseInt(val[2]);
			
			Arrays.fill(arr, a, b + 1, c);
			
		}
		sc.close();
		for(int i=1; i<=n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
