package boj1_9;

import java.util.Scanner;

//10807
public class Boj4a01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = sc.nextLine().split(" ");
		int v = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		
		for(String str : arr) {
			int num = Integer.parseInt(str);
			if(num == v) cnt++;
			
		}
		System.out.println(cnt);
	}

}
