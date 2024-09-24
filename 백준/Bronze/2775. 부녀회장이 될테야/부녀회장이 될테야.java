import java.util.*;
import java.io.*;

class Main {

    public List<Integer> solution(int[][] arr) {
        List<Integer> alist = new ArrayList<>();
        int[][] dp = new int[15][15];
        int idx = 1;

        for(int i=1;i<dp.length;i++) {
            dp[0][i] = i;
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp.length;j++) {
                for(int k=1;k<=j;k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            alist.add(dp[arr[i][0]][arr[i][1]]);
        }
        return alist;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][n];

      for(int i=0;i<n;i++) {
          arr[i][0] = Integer.parseInt(br.readLine());
          arr[i][1] = Integer.parseInt(br.readLine());
      }
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      for(int x : T.solution(arr)) {
          bw.write(x + "\n");
      }
      bw.flush();
      bw.close();
  }
}