package boj1_9;

import java.util.Scanner;

//10813
public class Boj4a06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[n + 1];
		int temp;
		for(int i=1; i<=n; i++) arr[i] = i;
			
		
		for(int i=1; i<=m; i++) {
			String[] str = sc.nextLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
			
			
		}
		sc.close();
		for(int i=1; i<=n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
