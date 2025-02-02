package solvedAc2;
// https://www.acmicpc.net/problem/10828
// 스택 구현하기
import java.io.*;
import java.util.*;

public class Main33 {
	static ArrayDeque<Integer> queue = new ArrayDeque<>();
	
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
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String select = st.nextToken();
			if (select.equals("push"))
				push(Integer.parseInt(st.nextToken()));
			else if (select.equals("pop"))
				sb.append(pop() + "\n");
			else if (select.equals("size"))
				sb.append(size() + "\n");
			else if (select.equals("empty"))
				sb.append(empty() + "\n");
			else if (select.equals("top"))
				sb.append(top() + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void push(int x) {
		queue.addFirst(x);
	}
	
	public static int pop() {
		if (queue.isEmpty()) return -1;
		else return queue.pollFirst();
	}
	
	public static int size() {
		return queue.size();
	}
	
	public static int empty() {
		if (queue.isEmpty()) return 1;
		else return 0;
	}
	
	public static int top() {
		if (queue.isEmpty()) return -1;
		else return queue.getFirst();
	}
}