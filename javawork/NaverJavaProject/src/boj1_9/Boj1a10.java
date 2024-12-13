package boj1_9;
//2588

import java.util.Scanner;
public class Boj1a10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in1 = sc.nextLine();
		String in2 = sc.nextLine();
		sc.close();
		int val1 = Integer.parseInt(in1);
		String[] val2 = in2.split("");
		int val3 = Integer.parseInt(val2[2]);
		int val4 = Integer.parseInt(val2[1]);
		int val5 = Integer.parseInt(val2[0]);
		
		int ans1 = val1 * val3;
		int ans2 = val1 * val4;
		int ans3 = val1 * val5;
		int ans4 = ans1 + ans2 * 10 + ans3 * 100;
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(ans4);
		
		
		
	}

}
