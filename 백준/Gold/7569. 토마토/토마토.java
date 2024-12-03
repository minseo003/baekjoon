import java.util.*;
import java.io.*;


public class Main {

    static class Point {
        int h;
        int x;
        int y;

        Point(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }

    static int M;  //열
    static int N;  //행
    static int H;  //상자의 개수
    static int[][][] board;
    static int[] nx = {1,-1,0,0,0,0};
    static int[] ny = {0,0,-1,1,0,0};
    static int[] nh = {0,0,0,0,1,-1};
    static Queue<Point> queue = new LinkedList<>();
    static boolean flag = false;
    static int answer = Integer.MIN_VALUE;

    static void bfs() {

        while(!queue.isEmpty()) {

            Point point = queue.poll();

            for (int i = 0; i < 6; i++) {

                int dh = point.h + nh[i];
                int dx = point.x + nx[i];
                int dy = point.y + ny[i];

                if (dh >= 0 && dh < H && dx >= 0 && dx < N && dy >= 0 && dy < M && board[dh][dx][dy] == 0) {
                    board[dh][dx][dy] = board[point.h][point.x][point.y] + 1;
                    queue.offer(new Point(dh,dx,dy));
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
        H = Integer.parseInt(st.nextToken());
        board = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int j = 0; j < M; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[k][i][j] = tmp;
                    if (tmp == 1) queue.offer(new Point(k,i,j));
                    if (tmp == 0) flag = true;
                }
            }
        }

        br.close();
        bfs();

        loop : for (int k = 0; k < H; k++) {
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < M; j++) {
                            if (board[k][i][j] == 0) {
                                answer = -1;
                                break loop;
                            }
                            answer = Math.max(answer,board[k][i][j]-1);
                        }
                    }
                }

        if (!flag) {
            bw.write(0 + "\n");
        } else {
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}