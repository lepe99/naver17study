package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main14 {
//10989
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		// 선택 정렬 (타임아웃)
//		for(int i=0; i<n; i++) {
//			for(int j=i+1; j<n; j++) {
//				if(arr[i] > arr[j]) {
//					int temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		
		// 기본 정렬
//		Arrays.sort(arr);
		
		// 계수 정렬
		int[] cnt = new int[10001]; // 제한 범위
		
		for(int i : arr) 
			cnt[i]++; // 카운팅
		
		for(int i=1; i<cnt.length; i++)
			cnt[i] += cnt[i - 1]; // 누적합
		
		int[] arrSort = new int[n];
		
		for(int i=n-1; i>=0; i--)
			arrSort[--cnt[arr[i]]] = arr[i]; // 마지막 인덱스부터 배치
		
		for(int i=0; i<n; i++) sb.append(arrSort[i]).append("\n");
		
		System.out.println(sb);
		
		
	}

}
