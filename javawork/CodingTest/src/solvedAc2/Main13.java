package solvedAc2;

import java.util.Scanner;

public class Main13 {
//2869
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		int day;
		int dist;
		
		day = (v - a) / (a - b);
		dist = (a - b) * day;
		
		while(true) {
			day++;
			dist += a;
			if(dist >= v) {
				System.out.println(day);
				break;
			}
			dist -= b;	
		}
	}

}
