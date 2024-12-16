package solvedAc1;

import java.util.Scanner;

public class Main3 {
//11720
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int sum = 0;
		
		String[] arr = sc.nextLine().split("");
		for(String str : arr) {
			sum += Integer.parseInt(str);
		}
		System.out.println(sum);
	}

}
