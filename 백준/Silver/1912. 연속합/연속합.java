import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp;
    static int[] arr;
    static int answer;

    static int solution(int n) {

        if(dp[n] == null) {
            dp[n] = Math.max(solution(n-1) + arr[n],arr[n]);

            answer = Math.max(dp[n],answer);
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n];
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        answer = arr[0];
        solution(n-1);
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}