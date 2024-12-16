package solvedAc2;

import java.util.Scanner;

public class Main3 {
//1978
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			if(isDemical(sc.nextInt())) cnt++;
		}
		
		System.out.println(cnt);
		
		
	}
	
	static boolean isDemical(int x) {
		if(x==1) return false;
		for(int i=2; i<=x/2; i++) {
			if(x % i == 0) return false;
		}
		return true;
	}

}

