package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16 {
//28702
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] fizzBuzz = new String[15];
		
		for(int i=0; i<15; i++) {
			if(i % 3 == 0 && i % 5 == 0) 
				fizzBuzz[i] = "FizzBuzz";
			
			else if(i % 3 == 0) 
				fizzBuzz[i] = "Fizz";
			
			else if(i % 5 == 0) 
				fizzBuzz[i] = "Buzz";
			
			else 
				fizzBuzz[i] = String.valueOf(i);
		}
		
		for(int i=0; i<3; i++) {
			String str = br.readLine();
			
			if(str.charAt(0) != 'F' && str.charAt(0) != 'B') {
				int val = Integer.parseInt(str) + 3 - i;
				
				String ans = fizzBuzz[val % 15].charAt(0) != 'F' 
							&& fizzBuzz[val % 15].charAt(0) != 'B' 
							? String.valueOf(val) 
							: fizzBuzz[val % 15];
				
				System.out.println(ans);
				
				break;
			}
		}
	}

}
