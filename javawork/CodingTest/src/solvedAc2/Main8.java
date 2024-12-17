package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main8 {
//2798
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		sc.nextLine();
		int[] arr = Arrays.stream(sc.nextLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n;j++) {
				for(int k=j+1; k<n; k++) {
					int val = arr[i] + arr[j] + arr[k];
					if(val > m) continue;
					max = Math.max(max, val);
				}
			}
		}
		System.out.println(max);
		
	}

}
