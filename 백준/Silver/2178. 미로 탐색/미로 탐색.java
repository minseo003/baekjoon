import java.util.*;
import java.io.*;

class Main {

    static int N,M;
    static int[][] board;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();

        board[x][y] = 0;
        dist[x][y] = 1;
        queue.offer(new Point(x,y));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        br.close();
        bfs(0,0);
        System.out.println(dist[N-1][M-1]);
    }
}