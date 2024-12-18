import java.util.Scanner;

public class Bo1074 {
	//1074
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ans = 0;
		
		while(n != 0) {
			int val = (int) Math.pow(2, n);
			int pos;
			
			if(r < val / 2) {
				if(c < val / 2) pos = 0;
				else pos = 1;
			} else {
				if(c < val / 2) pos = 2;
				else pos = 3;	
			}
			ans += pos * val / 2 * val / 2;
			r %= val / 2;
			c %= val / 2;
			n--;
		}
		
		System.out.println(ans);
	}
}

// 1234 5678
//2^3 / 2