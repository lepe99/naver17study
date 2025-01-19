package solvedAc2;
// https://www.acmicpc.net/problem/2751
// 더 쉬운 방법 있음
// 2, 5가 곱해질 때 마다 0이 하나씩 늘어남
// 2는 5보다 빈도수가 많으므로 5의 빈도수만 세면 됨
// n / 5 (첫번째 소인수 5 개수)
// n / 25 (두번째 소인수 5 개수) ...
// n / 5^k (k번째 소인수 5 개수)
// 반복문을 활용하여 카운트
import java.io.*;
import java.util.*;
import java.math.*;

public class Main19 {
    public static void main(String[] args) {
        run();
    }
    
    private static void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            
            int n = Integer.parseInt(br.readLine());
            Solution19 s = new Solution19();
            sb.append(s.solution19(n)).append("\n");
            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Solution19 {
    public int solution19(int n) {
        List<String> list = Arrays.asList(fact(n).toString().split(""));
        ArrayDeque<String> deque = new ArrayDeque<>(list);
        int cnt = 0;
        while (!deque.isEmpty()) {
            String tCase = deque.removeLast();
            if(!tCase.equals("0")) break;
            cnt++;
        }
        
        return cnt;
    }
    
    private static BigInteger fact(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            BigInteger mul = BigInteger.valueOf(n);
            BigInteger val = fact(n - 1).multiply(mul);
            return val;
        }
    }
}