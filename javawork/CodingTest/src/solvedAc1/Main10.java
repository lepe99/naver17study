package solvedAc1;

import java.util.Scanner;

public class Main10 {
//2577
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int res = a * b * c;
		String[] res1 = Integer.toString(res).split("");
		int[] arr = new int[9];
		int cnt = 0;
		
		for(String i : res1) {
			if(Integer.parseInt(i) != 0)
				arr[Integer.parseInt(i) - 1]++;
			else cnt++;
		}
		System.out.println(cnt);
		for(int i : arr) {
			System.out.println(i);
		}
		
	}

}
