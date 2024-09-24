import java.util.*;
import java.io.*;

class Main {

    public List<Integer> solution(int[] arr) {
        int[] dp = new int[11];
        List<Integer> alist = new ArrayList<>();
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4;i<dp.length;i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i=0;i<arr.length;i++) {
            alist.add(dp[arr[i]]);
        }
        return alist;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int x : T.solution(arr)) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }

}