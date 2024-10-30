import java.util.*;
import java.io.*;

class Main {

    static int N,M;
    static boolean[] ch;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == M) {
            for (int x : arr) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!ch[i]) {
                ch[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                ch[i] = false;
            }
        }
    }

    public static void main(String[] args)throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        br.close();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        ch = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }
}