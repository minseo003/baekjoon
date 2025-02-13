import java.util.*;
import java.io.*;

class Main {

    static boolean[][] dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }
        }

        for (int len = 2; len < n; len++) { // 길이를 점진적으로 증가
            for (int start = 1; start + len <= n; start++) {
                int end = start + len;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append((dp[start][end] ? 1 : 0) + "\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}