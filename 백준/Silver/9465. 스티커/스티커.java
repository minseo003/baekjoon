import java.util.*;
import java.io.*;


class Main {

    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp =  new int[2][n];
            board = new int[2][n];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++) {
                board[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++) {
                board[1][j] = Integer.parseInt(st.nextToken());
            }
            dp[0][0] = board[0][0];
            dp[1][0] = board[1][0];

            if (n > 1) {
                dp[0][1] = dp[1][0] + board[0][1];
                dp[1][1] = dp[0][0] + board[1][1];
            }

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + board[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + board[1][j];
            }
            bw.write(Math.max(dp[0][n-1], dp[1][n-1]) + " \n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}