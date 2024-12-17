package day1217;

import java.util.Scanner;

public class Ex7ArrayScore {

	public static void main(String[] args) {
		/*
		 * 인원수를 입력 후 그 인원수만큼 이름과 점수를 입력하고
		 * 등수와 총점과 평균을 구하여 출력하세요
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		int[] score, rank;
		String[] name;
		int total = 0;
		double avg;
		
		System.out.print("인원수 입력 : ");
		num = Integer.parseInt(sc.nextLine());
		score = new int[num];
		rank = new int[num];
		name = new String[num];
		
		for(int i=0; i<num; i++) {
			System.out.printf("이름 입력(%d/%d) : ", i + 1, num);
			name[i] = sc.nextLine();
			System.out.printf("점수 입력(%d/%d) : ", i + 1, num);
			score[i] = Integer.parseInt(sc.nextLine());
			// 합계 구하기
			total += score[i];
		}
		// 평균 구하기
		avg = (double) total/num;
		
		// 등수 구하기
		for(int i=0; i<num; i++) {
			rank[i] = 1;
			for(int j=0; j<num; j++)
				if(score[i] < score[j]) rank[i]++;	
		}
		
		// 출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("=".repeat(40));
		for(int i=0; i<num; i++)
			System.out.printf("%d\t%s\t%d\t%d\n", i + 1, name[i], score[i], rank[i]);
		System.out.printf("총점 : %d\t\t평균 : %.1f", total, avg);
	}

}
