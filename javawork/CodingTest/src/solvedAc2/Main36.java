package solvedAc2;
// https://www.acmicpc.net/problem/18110
// 우선순위 큐를 배열로 바꾼다고 정렬된 배열이 나오지 않는다.
import java.io.*;
import java.util.*;

public class Main36 {
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
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int trash = (int) Math.round(n * 0.15);
		int sum = 0;
		
		for (int i = trash; i < n - trash; i++)
			sum += arr[i];
		
		int avg = (int) Math.round((sum / (double) (n - 2 * trash)));
		
		System.out.println(avg);
		br.close();
	}
}