package boj1_9;

import java.util.Scanner;

//2753
public class Boj2a03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		int year = sc.nextInt();
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			System.out.println(1);
		else
			System.out.println(0);

	}

}
