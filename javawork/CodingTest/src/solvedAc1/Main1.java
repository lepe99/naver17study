package solvedAc1;

import java.util.*;

public class Main1 {
//3052
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int cnt = 0, num;
		Set<Integer> set = new HashSet<>();
		
		for(int i=1; i<=10; i++) {
			num = sc.nextInt();
			set.add(num % 42);
		}
		System.out.println(set.size());
		
	}

}
