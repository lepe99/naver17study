package solvedAc2;
// https://www.acmicpc.net/problem/11866
// 요세푸스 문제 0
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main35 {
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
		int k = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = IntStream.range(1, n + 1)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		
		sb.append("<");
		int idx = 0;
		while (!list.isEmpty()) {
			idx = ((idx + k - 1) % n--);
			int val = list.remove(idx);
			sb.append(val);
			if (!list.isEmpty()) sb.append(", ");
		}
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}
}