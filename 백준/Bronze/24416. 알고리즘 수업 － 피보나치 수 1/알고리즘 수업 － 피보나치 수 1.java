import java.util.*;
import java.io.*;


class Main {

    static int N;
    static int[] f;
    static int fiboCnt = 0;
    static int dynamicCnt = 0;

    static int fibo(int n) {
        if(n == 1 || n == 2) {
            fiboCnt++;
            return 1;
        }
        return (fibo(n-1) + fibo(n-2));
    }

    static int dynamic(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            dynamicCnt++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        f = new int[N+1];
        br.close();
        fibo(N);
        dynamic(N);
        System.out.print(fiboCnt + " " + dynamicCnt);
    }
}