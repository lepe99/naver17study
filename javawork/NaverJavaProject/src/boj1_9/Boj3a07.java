package boj1_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11021
public class Boj3a07 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			String val = br.readLine();
			String[] num = val.split(" ");
			int sum = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
			sb.append(String.format("Case #%d: %d\n", i, sum));
		}
		
		System.out.println(sb); // syso 는 객체를 인자로 받을 경우 toString() 자동 호출해서 안 써도 	
		
	}

}


//내일 다시