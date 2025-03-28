package boj1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//10951
public class Boj3a12 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line;
		int sum;
		
		while((line = br.readLine()) != null) {
			String[] arr = line.split(" ");
			sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
			sb.append(sum).append("\n");
			
		}
		System.out.println(sb);
	}

}
