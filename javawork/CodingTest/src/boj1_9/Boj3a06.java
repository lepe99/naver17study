package boj1_9;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.BufferedWriter;
//import java.io.OutputStreamWriter;

//15552 중요!
public class Boj3a06 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			String val = br.readLine();
			String[] arr = val.split(" ");
			int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
			sb.append(sum).append("\n");

		
		}
		System.out.println(sb);
//		bw.flush();
		br.close();
//		bw.close();	
		
			
		
	}

}
