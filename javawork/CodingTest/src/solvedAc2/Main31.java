package solvedAc2;
// https://www.acmicpc.net/problem/10773
// queue 를 이용해 0이 입력되면 가장 최근에 입력된 수를 제거하는 문제
import java.io.*;
import java.util.*;

public class Main31 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val == 0) stack.pollFirst();
			else stack.addFirst(val);
		}
		int sum = 0;
		for (int i : stack) sum += i;
		
		System.out.println(sum);
		br.close();
	}
}