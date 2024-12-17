package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
//1546
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int max = arr[n - 1];
		double sum = 0, avg;
		
		for(int score : arr) {
			sum += score / (double) max * 100;
		}
		avg = sum / n;
		System.out.println(avg);
	}

}
