package solvedAc2;
// https://www.acmicpc.net/problem/11651
// 우선순위큐 사용, 우선순위큐의 정렬은 입출력 수행시 시행되므로 다른 자료형으로 바꾸는것 피하기
import java.io.*;
import java.util.*;

public class Main24 {
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
        PriorityQueue<List<Integer>> queue =
                new PriorityQueue<>(Comparator
                        .comparing((List<Integer> pos) -> pos.get(1))
                        .thenComparing((List<Integer> pos) -> pos.get(0)));
        for (int i = 0; i < n; i++) {
            List<Integer> pos = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos.add(Integer.parseInt(st.nextToken()));
            pos.add(Integer.parseInt(st.nextToken()));
            queue.add(pos);
        }
        while(!queue.isEmpty()) {
            List<Integer> s = queue.poll();
            sb.append(s.get(0)).append(" ").append(s.get(1)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}