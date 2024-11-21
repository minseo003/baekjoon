import java.util.*;
import java.io.*;


class Main {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int M;  //열
    static int N;  //행
    static int[][] board;
    static int answer = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Point> queue = new LinkedList<>();
    static boolean flag = false;

    static void bfs() {

        while (!queue.isEmpty()) {
            Point p =queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                    board[nx][ny] = board[p.x][p.y] + 1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }


    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    queue.offer(new Point(i,j));
                }
            }
        }
        br.close();
        bfs();
        for (int i = 0; i < N; i++) {
            if (flag) {
                answer = -1;
                break;
            }
            for(int j = 0 ; j < M ; j++) {
                if (board[i][j] == 0) {
                    flag = true;
                }
                answer = Math.max(answer,board[i][j]-1);
            }
        }
        bw.write(answer + " ");
        bw.flush();
        bw.close();

    }
}