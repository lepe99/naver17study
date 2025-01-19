package solvedAc2;
// https://www.acmicpc.net/problem/2751
import java.io.*;
import java.util.*;

public class Main20 {
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void run() throws IOException {
		Solution20 s = new Solution20();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력부
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(Integer.parseInt(br.readLine()));
		
		
		StringBuilder sb = s.solution20(list); // 매개변수 지정
		System.out.println(sb);
		br.close();
	}
}


class Solution20 {
	StringBuilder sb = new StringBuilder();
	
	public StringBuilder solution20(List<Integer> list) {
		list.stream()
				.sorted()
				.forEach(x -> sb.append(x).append("\n"));
		
		return sb;
	}
}