package solvedAc1;

import java.util.Scanner;

public class Main12 {
//8958
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=t; i++) {
			int score = 0, cnt = 0;
			String[] arr = sc.nextLine().split("");
			for(String str : arr) {
				if(str.equals("O")) cnt++;
				else cnt = 0;
				score += cnt;
			}
			System.out.println(score);
		}
	}

}
