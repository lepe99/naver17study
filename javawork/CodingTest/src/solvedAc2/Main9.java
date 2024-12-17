package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main9 {
//15829
	public static void main(String[] args) throws IOException{
		int r = 31, m = 1234567891;
		long hash = 0L;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for(int i=0; i<l; i++) {
			long temp = (long) (str.charAt(i) - 96);
			BigInteger pow = BigInteger.valueOf(r).pow(i);
			BigInteger mod = BigInteger.valueOf(m);
			hash += BigInteger.valueOf(temp).multiply(pow).mod(mod).longValue();
		}	
		hash %= m;
		System.out.println(hash);
		
	}

}
//biginteger 사용법 숙지!