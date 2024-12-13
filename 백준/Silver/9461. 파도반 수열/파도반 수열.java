import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static long[] dp = new long[101];

    static long solution(int n) {
        if(n == 1 || n == 2 || n == 3) return dp[n];
        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = solution(n-3) + solution(n-2);
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(solution(n) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}