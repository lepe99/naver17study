package solvedAc1;

import java.util.Scanner;

public class Main11 {
//2920
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=8; i++) {
			sb.append(sc.nextInt());
		}
		
		if(sb.toString().equals("12345678")) System.out.println("ascending");
		else if(sb.toString().equals("87654321")) System.out.println("descending");
		else System.out.println("mixed");
		
		//객체는 주소를 참조하기 때문에 == 통한 직접비교 하지 말자!
		
		
	}

}
