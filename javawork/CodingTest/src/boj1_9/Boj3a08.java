package boj1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11022
public class Boj3a08 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			String[] arr = br.readLine().split(" ");
			int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
			sb.append(String.format("Case #%d: %s + %s = %d\n", i, arr[0], arr[1], sum));
		}
		System.out.print(sb);
	}

}
