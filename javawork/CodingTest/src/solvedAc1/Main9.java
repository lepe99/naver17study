package solvedAc1;

import java.util.Scanner;

public class Main9 {
//10250
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int i=1; i<=t; i++) {
			String[] str = sc.nextLine().split(" ");
			int h = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			int n = Integer.parseInt(str[2]);

			
			int a = n % h == 0 ? n / h : n / h + 1;
			int b = n % h == 0 ? h : n % h;
			System.out.printf("%d%02d\n", b, a);
		}
		
	}

}
