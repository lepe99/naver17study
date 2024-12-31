package solvedAc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main17 {
// 1181
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<PriorityQueue<String>> list = new ArrayList<>(); // 우선순위 큐 넣을 수 있는 리스트 생성
		
		for(int i=0; i<50; i++) {
			list.add(new PriorityQueue<>()); // 문자열의 길이 50, 리스트 안에 길이 범위 만큼의 우선순위 큐 생성
		}
	
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			list.get(str.length() - 1).add(str); // 문자열의 길이 - 1 값의 인덱스에 있는 우선순위 큐에 입력
			// 하나의 우선순위 큐에는 같은 길이를 가진 문자열만 모임
		}
		
		for(PriorityQueue<String> s : list) {
			String temp = "";
			while(!s.isEmpty()) { // 비어 있지 않은 우선순위 큐에서만 수행
				String pol = s.poll(); // 큐의 헤드 제거와 함께 반환 
				if(!temp.equals(pol)) { // 중복 제거
					temp = pol;
					sb.append(pol).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
