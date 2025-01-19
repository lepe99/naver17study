package solvedAc2;
// https://www.acmicpc.net/problem/1436
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main18 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int num = 665;
		int cnt = 0;
		while(cnt != n) {
			num++;
			List<String> list = Arrays.asList(Integer.toString(num).split(""));
			int freq = Collections.frequency(list, "6"); // Collections.frequency() : 리스트에서 특정 요소의 빈도수를 반환
			if (freq < 3) continue;
			cnt++;
		}
		System.out.println(num);
	}
}