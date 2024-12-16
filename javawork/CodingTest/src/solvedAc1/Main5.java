package solvedAc1;

import java.util.Scanner;

public class Main5 {
//10809
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		int[] arr = new int[26];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		
		for(int i=0; i<s.length; i++) {
			if(arr[s[i] - 'a'] == -1) arr[s[i] - 'a'] = i;
		}
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
	}

}
