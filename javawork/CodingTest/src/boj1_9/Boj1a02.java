package boj1_9;

import java.util.Scanner;

public class Boj1a02 {
//1000
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String val = sc.nextLine();
			String[] ans = val.split(" ");
			System.out.println(Integer.parseInt(ans[0]) + Integer.parseInt(ans[1]));
		}
	}

}
