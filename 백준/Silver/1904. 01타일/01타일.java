import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] dp = new int[1000001];
    static int answer;

    static int solution(int x) {
        if (dp[x] == -1) {
            dp[x] =  solution(x-1) + solution(x-2);
        }
        return dp[x] % 15746;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 3; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        bw.write(solution(N) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}