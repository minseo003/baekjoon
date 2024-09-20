import java.io.*;

class Main {
    static Integer[][] dp = new Integer[41][2];


    public Integer[] fibo(int n) {

        if (n == 0 || n == 1) {
            return dp[n];
        }

        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibo(n - 1)[0] + fibo(n - 2)[0];
            dp[n][1] = fibo(n - 1)[1] + fibo(n - 2)[1];
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception{
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for (int x : arr) {
            Integer[] answer = T.fibo(x);
            System.out.println(answer[0] + " " + answer[1]);

        }
    }
}