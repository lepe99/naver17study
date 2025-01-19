package solvedAc2;

import java.io.*;

public class Main {
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
        
        
        sb.append(n).append("\n");
        System.out.println(sb);
        br.close();
    }
}