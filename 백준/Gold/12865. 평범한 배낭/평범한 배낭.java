import java.util.*;
import java.io.*;

class obj {
    int w;
    int v;

    public obj(int w, int v) {
        this.w =w;
        this.v = v;
    }
}

class Main {

    static obj[] objs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];
        objs = new obj[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            objs[i] = (new obj(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (objs[i].w > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-objs[i].w] + objs[i].v);
                }
            }
        }
        bw.write(dp[n][k] + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}