package solvedAc2;
// https://www.acmicpc.net/problem/1018
import java.io.*;
import java.util.*;

class Main25 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 입력 받기
		// 첫번째 B, 첫번째 W로 시작 시 체스판 조건 만족하지 않는 요소 검사하고
		// 그 요소 인덱스에 1 작성하는 배열 생성
		// 두 배열을 8*8 사이즈로 순회하며 최소값 찾기
		int[][] arr = new int[n][m];
		int[][] chkW = new int[n][m];
		int[][] chkB = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				String a = line[j];
				if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					if(a.equals("W")) {
						chkW[i][j] = 0;
						chkB[i][j] = 1;
					} else {
						chkW[i][j] = 1;
						chkB[i][j] = 0;
					}
				} else {
					if(a.equals("B")) {
						chkW[i][j] = 0;
						chkB[i][j] = 1;
					} else {
						chkW[i][j] = 1;
						chkB[i][j] = 0;
					}
				}
			}
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int cntW = 0, cntB = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						cntW += chkW[i + k][j + l];
						cntB += chkB[i + k][j + l];
					}
				}
				queue.add(cntW);
				queue.add(cntB);
			}
		}
		int ans = queue.poll();
		
		System.out.println(ans);
		br.close();
	}
}