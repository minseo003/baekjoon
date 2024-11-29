import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[] number;
    static int[] cal = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void dfs(int num, int idx) {

        if (idx == N) {
            max = Math.max(max,num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;

                switch (i) {
                    case 0 : dfs(num + number[idx], idx + 1); break;
                    case 1 : dfs(num - number[idx], idx + 1); break;
                    case 2 : dfs(num * number[idx], idx + 1); break;
                    case 3 : dfs(num / number[idx], idx + 1); break;
                }
                cal[i]++;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N  = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < cal.length; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        dfs(number[0],1);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}