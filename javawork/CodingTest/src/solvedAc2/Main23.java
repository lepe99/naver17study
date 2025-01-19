package solvedAc2;
// https://www.acmicpc.net/problem/11650
// Comparator의 comparing()을 사용하여 키를 추출해서 정렬
// 노션 제네릭/컬렉션 마지막 단락에 정리해둠
import java.io.*;
import java.util.*;

public class Main23 {
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
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.stream(arr)
				.sorted(Comparator.comparing((int[] a) -> a[0])
						.thenComparing((int[] a) -> a[1]))
				.forEach(s -> sb.append(s[0]).append(" ")
						.append(s[1]).append("\n"));
		
		System.out.println(sb);
		br.close();
	}
}