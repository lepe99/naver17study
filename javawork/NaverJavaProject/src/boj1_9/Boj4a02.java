package boj1_9;

import java.util.Scanner;

//10871
public class Boj4a02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int x = sc.nextInt();
		sc.nextLine();
		String[] arr = sc.nextLine().split(" ");
		sc.close();
		
		for(int i=0; i<n; i++) {
			if(Integer.parseInt(arr[i]) < x) sb.append(arr[i]).append(" ");
			
		}
		System.out.println(sb);
	}

}
