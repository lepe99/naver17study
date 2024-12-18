package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex2Lotto {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money;
		int[] lotto = new int[6];
		Random r = new Random(); // 랜덤 클래스 이용
		
		// 금액 입력
		System.out.print("금액을 입력해주세요 : ");
		money = sc.nextInt();
		
		// 1000원 미만이면 종료
		if(money<1000) {
			System.out.println("** 금액이 부족합니다 **");
			return;
		}
		
		// 금액만큼 로또 숫자 발생 후 출력 (오름차순)
		int t = money / 1000;
		for(int n=1; n<=t; n++) {
			System.out.printf("%3d회 : ", n);
			
			// lotto 배열에 1~45 사이 난수발생, 중복체크
			Loop:
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = r.nextInt(45) + 1;
				for(int j=0; j<i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
						continue Loop;
					}
				}
			}
			// 오름차순 정렬
			for(int i=0; i<lotto.length; i++) {
				for(int j=i+1; j<lotto.length; j++) {
					if(lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}
			
			// 출력
			for(int i : lotto)
				System.out.printf("%4d", i);
			System.out.println();
		}
		
	}

}
