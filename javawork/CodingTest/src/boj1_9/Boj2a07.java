package boj1_9;
//2480
import java.util.Scanner;

public class Boj2a07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		for(int i=0; i<3; i++) {
			int k = sc.nextInt();
			arr[k] += 1;
		}
		sc.close();
		
		int ans = 0;
		int max = 0;
		
		for(int i=1; i<=6; i++) {
			if(arr[i] == 3) {
				ans = 10000 + 1000 * i;
				break;
			}
			else if(arr[i] == 2) {
				ans = 1000 + 100 * i;
				break;
			}
			else if(arr[i] == 1)
				max = i;
				
		}
		ans = ans == 0 ? 100 * max : ans;
		System.out.println(ans);
		
	}

}
