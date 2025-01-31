package solvedAc2;
// https://www.acmicpc.net/problem/9012
import java.io.*;
import java.util.*;

public class Main30 {
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
		
		loop:
		for (int i = 0; i < n; i++) {
			ArrayDeque<Boolean> stack = new ArrayDeque<>();
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					stack.addFirst(true);
					continue;
				}
				if (s.charAt(j) == ')') {
					if (stack.isEmpty()) {
						sb.append("NO\n");
						continue loop;
					}
					stack.pollFirst();
				}
			}
			if (stack.isEmpty())
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}