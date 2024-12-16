package solvedAc2;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
//2231
// 범위를 최대 범위로 잡지 않고 구해도 되는 부분까지 줄여서 자원 절약!, 브루트포스 알고리즘
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int[] arr = new int[1000001];
		int[] arr = new int[n + 1];
//		boolean find = false;
		
//		for(int i=1; i<=1000000; i++) {
		for(int i=1; i<=n; i++) {
			arr[i] = i;
		}
		
//		for(int i=1; i<=1000000; i++) {
		for(int i=1; i<=n; i++) {
			int[] arr2 = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
			if(arr[i]==i) {
				for(int v : arr2) arr[i] += v;
			}
		}	
//		for(int i=1; i<=1000000; i++) {
		for(int i=1; i<=n; i++) {
			if(arr[i] == n) {
				System.out.println(i);
//				find = true;
//				break; // return 으로 변경시 아래 복잡한조건문 필요 x
				return;
			}
		}
//		if(!(find)) System.out.println(0);
		System.out.println(0);

		
		
	}

}
