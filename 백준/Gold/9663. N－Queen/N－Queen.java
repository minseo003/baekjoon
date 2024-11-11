import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void dfs(int depth) {
        if(depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possible(depth)) {
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            }
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
        arr = new int[N];
        dfs(0);
        System.out.println(count);
    }

}