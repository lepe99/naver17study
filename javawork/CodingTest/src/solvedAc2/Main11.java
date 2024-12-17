package solvedAc2;

import java.util.Scanner;

public class Main11 {
//2609
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = 1;
		
		if(Math.max(a, b) % Math.min(a, b) == 0) gcd = Math.min(a, b);
		else {
			for(int i=1; i<=Math.min(a, b) / 2; i++) {
				if(a % i == 0 && b % i == 0)
					gcd = i;
			}	
		}
		int lcm = a * b / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
		//최대공약수 최소공배수 구하기
		// 1. 유클리드 호제법 a % b = r 일떄, gcd(a, b) = gcd(b, r) r == 0까지 
		// 2. BigInteger 클래스의 a.gcd(b) (비추천) 
	}

}
