package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0, cnt1 = 0, cnt2 = 0, age;
		double avg;
		
		for(int i=0; i<5; i++) {
			System.out.print("나이 입력(" + (i + 1) + " / 5) : ");
			age = sc.nextInt();
			//0 ~ 100세를 벗어나는경우 다시 입력 (인원수에는 제외, continue 이용)_
			if(age>100 || age<0) {
				System.out.println("다시 입력해 주세요");
				i--;
				continue;
			}
			
			if(age>=40) cnt1++;
			else cnt2++;
			sum += age;
		}
		avg = (double) sum / 5;
		
		
		System.out.printf("40세 이상은 %d명\n", cnt1);
		System.out.printf("40세 미만은 %d명\n", cnt2);
		System.out.printf("평균 나이는 %4.1f세", avg);
		
		
	}
		
}
