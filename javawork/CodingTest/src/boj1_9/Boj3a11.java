package boj1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10952
public class Boj3a11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 1;
				
		while(true) {
			String[] arr = br.readLine().split(" ");
			sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
			if (sum == 0) break;
			sb.append(sum).append("\n");	
			
		}
		System.out.print(sb);
	}

}
