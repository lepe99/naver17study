package solvedAc2;
// https://www.acmicpc.net/problem/4949
// stack 구현하여 쉽게 해결 가능한 문제
// 끝마친 후 스택이 비어있는지 여부도 확인하자
import java.io.*;
import java.util.*;

public class Main29 {
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
		
		loop:
		while (true) {
			String s = br.readLine();
			if (s.equals(".")) break loop;
			
			ArrayDeque<Character> stack = new ArrayDeque<>();
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[') stack.addFirst(c);
				try {
					if (c == ')' && stack.pollFirst() != '(') {
						sb.append("no\n");
						continue loop;
					}
					if (c == ']' && stack.pollFirst() != '[') {
						sb.append("no\n");
						continue loop;
					}
				} catch (NullPointerException e) {
					sb.append("no\n");
					continue loop;
				}
				
			}
			if (stack.isEmpty())
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.println(sb);
		br.close();
	}
}