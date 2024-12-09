import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        int cnt;
        boolean destroyed;
        public Point(int x, int y,int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    static int N;
    static int M;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static Queue<Point> queue = new LinkedList<>();
    static boolean flag = false;

    static int bfs() {
        queue.add(new Point(0 ,0,1,false));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();

            if(tmp.x == N-1 && tmp.y == M-1) return tmp.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];  //행
                int ny = tmp.y + dy[i];  //열

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (tmp.destroyed) {
                    if (board[nx][ny] == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, tmp.cnt + 1, true));
                    }
                } else {
                    if (board[nx][ny] == 1) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx,ny,tmp.cnt+1,true));
                    } else if (!visited[nx][ny][0]) {
                        visited[nx][ny][0] = true;
                        queue.offer(new Point(nx,ny,tmp.cnt+1,false));
                    }
                }
            }
        }
        return -1;
    }

        public static void main (String[]args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new boolean[N][M][2];
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split("");
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(s[j]);
                }
            }
            br.close();
            bw.write(bfs() + "\n");
            bw.flush();
            bw.close();
        }

}