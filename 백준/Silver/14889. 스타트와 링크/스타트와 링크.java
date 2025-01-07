import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] ch;
    static int Min = Integer.MAX_VALUE;

    static void dfs(int idx, int depth) {

        if (depth == n/2) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                dfs(i + 1, depth + 1);
                ch[i] = false;
            }
        }
    }


    static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ch[i] == true && ch[j] == true) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                } else if (ch[i] == false && ch[j] == false) {
                    team_link += arr[i][j];
                    team_link += arr[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);
        if (val == 0) {
            System.out.print(val);
            System.exit(0);
        }
        Min = Math.min(val,Min);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        bw.write(Min + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}