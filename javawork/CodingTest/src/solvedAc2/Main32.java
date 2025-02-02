package solvedAc2;
// https://www.acmicpc.net/problem/10816
// 배열을 통한 메모리제이션 방식 사용할 수도 있었으나
// Map을 이용해 각 숫자의 개수를 저장하고, 해당 숫자의 개수를 출력하는 방식으로 구현
import java.io.*;
import java.util.*;

public class Main32 {
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
		
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (map.containsKey(val)) map.put(val, map.get(val) + 1);
			else map.put(val, 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) sb.append(map.get(key) + "\n");
			else sb.append("0\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}