package solvedAc2;
// https://www.acmicpc.net/problem/1920
// 배열에서 수 찾기
// 이진탐색 사용 -> Collections.binarySearch 는 List인터페이스 구현한 객체에 대해서만 사용가능
// stream 이용 익숙해지기
import java.io.*;
import java.util.*;
import java.util.stream.*; // stream 의 Collectors 사용하기위해 추가
// * 는 하위 클래스까지 추가 못해줌

public class Main27 {
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
		List<Integer> list1 = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());
		int m = Integer.parseInt(br.readLine());
		List<Integer> list2 = Arrays.stream(br.readLine().split(" "))
				.map(Integer::parseInt).collect(Collectors.toList());
		Collections.sort(list1);
		
		for (int i : list2) {
			if (Collections.binarySearch(list1, i) >= 0) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}