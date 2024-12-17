package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10 {
//1259
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String inp = br.readLine();
			if(inp.equals("0")) break; 			// 객체 비교는 equals 사용 !!!!
			boolean fal = true;
			
			for(int i=0; i<inp.length()/2; i++) {
				if(inp.charAt(i) != inp.charAt(inp.length() - 1 - i)) {
					fal = false;
					break;
				} 
			}
			System.out.println(fal ? "yes" : "no");
		}
	}
}
