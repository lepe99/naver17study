package programmers;
// https://programmers.co.kr/learn/courses/30/lessons/12946
// 하노이의 탑
// 재귀로 풀이
import java.util.*;

class Sol1 {
    static List<int[]> ansList = new ArrayList<>();
    
    public int[][] solution(int n) {
        topDown(n, 1, 3);
        int[][] answer = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }
    
    public static void topDown(int n, int a, int b) { // 재귀 함수
        if(n == 1) {
            ansList.add(new int[]{a, b});
            return;
        }
        topDown(n - 1, a, 6 - a - b);
        ansList.add(new int[]{a, b});
        topDown(n - 1, 6 - a - b, b);
    }
}