import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static Integer[][] arr;
    static Integer[][] dp;

    static int solution(int depth, int start) {

        if(depth == n-1) return dp[depth][start];

        if(dp[depth][start] == null) {
            dp[depth][start] = Math.max(solution(depth+1,start),solution(depth+1,start+1)) + arr[depth][start];
        }
        return dp[depth][start];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new Integer[n][n];
        dp = new Integer[n][n];
        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == n-1) {
                    dp[i][j] = arr[i][j];
                }
            }
        }
        int answer = solution(0,0);
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}