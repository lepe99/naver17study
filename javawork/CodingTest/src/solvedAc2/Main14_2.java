package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14_2 {
//10989
//계수 정렬로 다시
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		
		for(int i=1; i<=n; i++)
			cnt[Integer.parseInt(br.readLine())]++;
		
		for(int i=1; i<cnt.length; i++) {
			while(cnt[i]>0) {
				sb.append(i).append("\n");
				cnt[i]--; // 부분 합 없이 순서대로
			}
		}
		System.out.println(sb);
		
		//계수 정렬 counting sort 숙지 !
	
	}

}
