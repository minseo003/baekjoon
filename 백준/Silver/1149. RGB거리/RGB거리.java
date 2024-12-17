import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] dp;

    static int solution(int n, int color){

        if(dp[n][color] == 0) {
            if (color == 0) {
                dp[n][0] = Math.min(solution(n-1,1),solution(n-1,2)) + arr[n][0];
            } else if (color == 1) {
                dp[n][1] = Math.min(solution(n - 1, 0), solution(n - 1, 2)) + arr[n][1];
            } else {
                dp[n][2] = Math.min(solution(n-1,0),solution(n-1,1)) + arr[n][2];
            }
        }
        return dp[n][color];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 3 ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        int answer = Math.min(solution(n-1,0),Math.min(solution(n-1,1),solution(n-1,2)));
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}