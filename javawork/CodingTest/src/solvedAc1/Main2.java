package solvedAc1;

import java.util.Scanner;

public class Main2 {
//2675
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=t; i++) {
			StringBuilder sb = new StringBuilder();
			String[] str = sc.nextLine().split(" ");
			int r = Integer.parseInt(str[0]);
			String[] s = str[1].split("");
			for(String ch : s) {
				for(int j=1; j<=r; j++) sb.append(ch);
				
			}
			System.out.print(sb + "\n");
		}
		
	}

}
