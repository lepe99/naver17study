package day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex5ArrayBingo {

	public static void main(String[] args) {
		/*
		 * 3행 3열의 2차원 배열 생성 / 1~3 난수 생성
		 * 빙고 조회 후 빙고 : 2개 와 같이 출력
		 * 없을경우 꽝! 출력
		 * 엔터 누를때마다 난수 발생
		 * q, Q 를 누르면 프로그램 종료
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("행렬 개수 입력 : ");
		int n = Integer.parseInt(sc.nextLine());
		
		System.out.print("랜덤 인수 입력 : ");
		int ran = Integer.parseInt(sc.nextLine());
		
		int[][] arr = new int[n][n];
		Random r = new Random();
		
		System.out.println("=".repeat(20));
		System.out.println();
		
		
		while(true) {
			// 난수 발생
			for(int i=0; i<n; i++) 
				for(int j=0; j<n; j++) 
					arr[i][j] = r.nextInt(ran) + 1;
			
			// 출력
			for(int i=0; i<n; i++) { 
				for(int j=0; j<n; j++)
					System.out.printf("%3d", arr[i][j]);
				System.out.println();
			}
			
			// 빙고 계산
			int bingo = 0;
			int temp = 0;
			boolean bin = true;
			
			for(int i=0; i<n; i++) { 
				bin = true;
				temp = arr[i][0];
				for(int j=1; j<n; j++) { // 가로
					if(arr[i][j] != temp) { 
						bin = false;
						break;
					}
				}
				if(bin) bingo++;
				
				bin = true;
				temp = arr[0][i];
				for(int j=1; j<n; j++) { // 세로
					if(arr[j][i] != temp) {
						bin = false;
						break;
					}
				}
				if(bin) bingo++;		
			}
				
			
			for(int i=1; i<n; i++) { // 대각1
				bin = true;
				temp = arr[0][0];
				if(arr[i][i] != temp) {
					bin = false;
					break;
				}
			}
			if(bin) bingo++;
			
			for(int i=1; i<n; i++) { // 대각2
				bin = true;
				temp = arr[0][n - 1];
				if(arr[i][n - 1 - i] != temp) {
					bin = false;
					break;
				}
			}
			if(bin) bingo++;
			
			// 빙고 출력, 없으면 꽝
			if(bingo == 0) System.out.println("\t꽝!!");
			else System.out.println("\t빙고 " + bingo + "개");
			
			System.out.println("=".repeat(20));
			
			// q 입력시 종료
			if(sc.nextLine().equalsIgnoreCase("q")) {
				System.out.println("빙고 종료");
				break;
			}
		}
	}
}
