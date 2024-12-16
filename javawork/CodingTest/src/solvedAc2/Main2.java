package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
//30802
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] size = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int t = sc.nextInt();
		int p = sc.nextInt();
		int sum = 0;
		
		for(int val : size) {
			sum += val % t == 0 ? val / t : val / t + 1;
		}
		System.out.println(sum);
		System.out.print(n / p + " ");
		System.out.print(n % p);
	}

}
