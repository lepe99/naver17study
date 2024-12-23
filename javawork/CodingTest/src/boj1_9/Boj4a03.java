package boj1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

//10818
public class Boj4a03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int max = -1000000, min = 1000000;
		
		for (String str : arr) {
			int num = Integer.parseInt(str);
			if(num > max) max = num;
			if(num < min) min = num;
			
		}
		System.out.println(min + " " + max);
	}

}
