import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static Integer[] dp;

    static int solution(int x) {
        if(dp[x] == null) {
            dp[x] = Math.max(Math.max(solution(x - 2), solution(x - 3) + arr[x - 1]) + arr[x], solution(x - 1));
        }

        return dp[x];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];

        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 0;
        dp[1] = arr[1];

        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }
        bw.write(solution(n) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}
