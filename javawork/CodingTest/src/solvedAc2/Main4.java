package solvedAc2;

import java.util.Scanner;

public class Main4 {
//2292
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		int array = 1;
				
		while(n > array) {
			array += ++cnt * 6;
		}
		System.out.println(cnt + 1);
	}

}
