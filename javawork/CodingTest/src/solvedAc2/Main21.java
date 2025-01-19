package solvedAc2;
// https://www.acmicpc.net/problem/7568
// 케이스 적은 등수 비교
// rank 선언해 놓고 자신보다 큰 값 포착 시 마다 1씩 증가시킨다
import java.io.*;

public class Main21 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		Solution21 s = new Solution21();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력부
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			String[] inp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(inp[0]);
			arr[i][1] = Integer.parseInt(inp[1]);
		}
		
		StringBuilder sb = s.solution21(n, arr); // 매개변수 지정
		System.out.println(sb);
		br.close();
	}
}


class Solution21 {
	StringBuilder sb = new StringBuilder();
	
	public StringBuilder solution21(int n, int[][] arr) {
		for (int i = 0; i < n; i++) {
			int rank = 1;
			for (int j = 0; j < n; j++) {
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					rank++;
			}
			sb.append(rank).append(" ");
		}
		return sb;
	}
}