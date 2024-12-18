package day1218;

import java.util.Scanner;

public class Ex1ArraySwitch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 인원수 입력 / 인원수만큼 이름과 자바 스프링 두 점수 입력
		 * 총점 평균 등수 등급 구하기 
		 */
		int num;
		int[] java, spring, sum, rank;
		String[] name, grade;
		double[] avg;
		
		System.out.print("인원수 입력 : ");
		num = Integer.parseInt(sc.nextLine());
		// 메모리 할당
		java = new int[num];
		spring = new int[num];
		sum = new int[num];
		rank = new int[num];
		
		name = new String[num];
		grade = new String[num];
		
		avg = new double[num];
		
		// 입력 (총점, 평균 같이)
		for(int i=0; i<num; i++) {
			System.out.printf("이름 입력(%d/%d) : ", i + 1, num);
			name[i] = sc.nextLine();
			System.out.printf("자바 점수 입력(%d/%d) : ", i + 1, num);
			java[i] = Integer.parseInt(sc.nextLine());
			System.out.printf("스프링 점수 입력(%d/%d) : ", i + 1, num);
			spring[i] = Integer.parseInt(sc.nextLine());
			
			sum[i] = java[i] + spring[i];
			avg[i] = sum[i] / 2.0; // 소숫점 자리 붙여서 double 쉽게 표현
			System.out.println();
		}
		
		// 등수
		for(int i=0; i<num; i++) {
			rank[i] = 1;
			for(int j=0; j<num; j++) {
				if(avg[i] < avg[j])
					rank[i]++;
			}
		}
		
		// 등급
//		for(int i=0; i<num; i++) {
//			switch((int) avg[i] / 10) {
//			case 10, 9:
//				grade[i] = "우수장학생";
//				break;
//			case 8:
//				grade[i] = "일반장학생";
//				break;
//			default:
//				grade[i] = "해당없음";
//				break;
//				
//			}
//		}
		
		// jdk 12, 13 에서 추가된 문법
		for(int i=0; i<num; i++) {
			grade[i] = switch((int) avg[i] / 10) {
				case 10, 9 -> "우수장학생";
				case 8 -> "일반장학생";
				default -> "해당없음";
			};
		}
		
		// 출력
		System.out.println("번호\t이름\t자바\t스프링\t총점\t평균\t등수\t등급");
		System.out.println("=".repeat(60));
		
		for(int i=0; i<num; i++) 
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%.1f\t%d\t%s\n"
					, i + 1, name[i], java[i], spring[i], sum[i], avg[i], rank[i], grade[i]);
		
		
	}

}
