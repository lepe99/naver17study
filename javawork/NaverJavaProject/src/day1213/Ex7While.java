package day1213;

import java.util.Scanner;

public class Ex7While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score, total = 0, count = 0; // 증감연산자 쓰려면 초기값 할당 해야함
		double avg;
		
		while(true) {
			System.out.println("점수입력(종료시 0)");
			score = sc.nextInt();
			sc.close();	
			
			if(score==0) break;
			if(score<0 || score>100) {
				System.out.println("잘못 입력된 점수입니다");
				continue; // 다시 처음으로(조건식) 이동
			}
			count++;
			total += score;
		}
		
		avg = (double) total / count;
		
		System.out.println("총 입력한 점수 갯수 : " + count);
		System.out.println("점수의 총 합계 : " + total);
		System.out.printf("점수들의 평균 : %5.2f\n	", avg);
	}

}
