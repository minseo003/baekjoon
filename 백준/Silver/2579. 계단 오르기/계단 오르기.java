import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static Integer[] dp;

    static int solution(int n) {

        if (dp[n] == null) {
            dp[n] = Math.max(solution(n-2),solution(n-3) + arr[n-1]) + arr[n];
        }
        return dp[n];
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];

        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1]+arr[2];
        }
        bw.write(solution(n) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}