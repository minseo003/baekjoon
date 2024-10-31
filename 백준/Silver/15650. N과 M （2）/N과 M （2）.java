import java.util.*;
import java.io.*;

class Main {

    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int at, int depth) {

        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
                arr[depth] = i;
                dfs(i+1,depth+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);
    }
}