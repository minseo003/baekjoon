import java.util.*;
import java.io.*;

public class Main {

    static class Info {
        int start;
        int cnt;
        Info(int start, int cnt) {
            this.start = start;
            this.cnt = cnt;
        }
    }

    static int N;
    static int M;
    static int[] board = new int[101];
    static boolean[] ch = new boolean[101];
    static Queue<Info> queue = new LinkedList<>();

    static void bfs(int start) {
        queue.add(new Info(start,0));
        ch[start] = true;

        while (!queue.isEmpty()) {
            Info tmp = queue.poll();

            if(tmp.start == 100) {
                System.out.println(tmp.cnt);
                return;
            }

            for(int i = 1; i < 7 ; i++) {
                int next = tmp.start + i;
                if(next <= 100) {
                    if(board[next] != 0) next = board[next];
                    if(!ch[next]) {
                        ch[next] = true;
                        queue.add(new Info(next,tmp.cnt+1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y; //x로 가게되면 y로 이동할 수 있도록 y의 인덱스 값을 넣어줌.
        }
        br.close();
        bfs(1);
    }
}