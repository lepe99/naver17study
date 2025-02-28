package solvedAc2;
// https://www.acmicpc.net/problem/1644
// 무조건 다시보고 이해, 정리
import java.io.*;
import java.util.*;

public class Main26 {
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
		
		// 1. n보다 작은 소수 구하기 (에라토스테네스의 체)
		List<Integer> decimalList = getPrimes(n);
		
		// 2. 투포인터 활용
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while (true) {
			if (sum >= n) {
				if (sum == n) cnt++;
				sum -= decimalList.get(left++);
			} else if (right == decimalList.size()) {
				break;
			} else {
				sum += decimalList.get(right++);
			}
		}
		System.out.println(cnt);
	}
	
	private static List<Integer> getPrimes(int x) {
		List<Integer> decimalList = new ArrayList<>();
		
		boolean[] isPrime = new boolean[x + 1];
		
		if (x >= 2) isPrime[2] = true;
		if (x >= 3) isPrime[3] = true;
		
		for (int i = 5; i <= x; i += 6) {
			isPrime[i] = true;
			if (i + 2 <= x)
				isPrime[i + 2] = true;
		}
		for (int i = 5; i * i <= x; i += (i % 6 == 1) ? 4 : 2) {
			int next = (i % 6 == 1) ? 4 : 2;
			if (isPrime[i]) {
				for (int j = i * i; j <= x; j += 6 * i) {
					isPrime[j] = false;
					if (j + next * i <= x)
						isPrime[j + next * i] = false;
				}
			}
		}

		for (int i = 2; i <= x; i++) {
			if (isPrime[i]) {
				decimalList.add(i);
			}
		}
		return decimalList;
	}
}