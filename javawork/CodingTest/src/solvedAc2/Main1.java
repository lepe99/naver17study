package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
//4153
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String[] arr = sc.nextLine().split(" ");
			int[] arrInt = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arrInt);
			
			if(arrInt[0] == 0) break;
			
			if(Math.pow(arrInt[0], 2) + Math.pow(arrInt[1], 2) == Math.pow(arrInt[2], 2)) {
				System.out.println("right");
			} else System.out.println("wrong");
			
		
		}
	}

}
