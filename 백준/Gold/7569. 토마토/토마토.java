import java.io.*;
import java.util.*;

class point {
    int x;
    int y;
    int h;

    public point(int h,int x, int y) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class Main {
    static int n,m,h;
    static int[][][] board;
    static int[] dx = {0,1,0,-1,0,0};
    static int[] dy = {1,0,-1,0,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static boolean flag = false;
    static Queue<point> queue = new LinkedList<>();

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken()); //가로길이
        n = Integer.parseInt(st.nextToken()); //세로길이
        h = Integer.parseInt(st.nextToken()); //높이
        board = new int[h][n][m];

        for(int i = 0 ; i < h ; i++) {
            for(int j = 0; j < n ; j++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int x = 0 ; x < m ; x++) {
                    board[i][j][x] = Integer.parseInt(st.nextToken());
                    if(board[i][j][x] == 1) queue.offer(new point(i,j,x));
                    if(board[i][j][x] == 0) flag = true;
                }
            }
        }
        bfs();
        int answer = Integer.MIN_VALUE;
        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < n ; j++) {
                for(int x = 0 ; x < m ; x++) {
                    if(board[i][j][x] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    answer = Math.max(answer,board[i][j][x]);
                }
            }
        }
        System.out.println(answer-1);
    }

    static void bfs() {
        if(!flag) {
            System.out.println(0);
            System.exit(0);
        }

        while(!queue.isEmpty()) {
            point tmp = queue.poll();

            for(int i = 0 ; i < 6 ; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                int nh = tmp.h + dh[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && nh >= 0 && nh < h && board[nh][nx][ny] == 0) {
                    queue.offer(new point(nh,nx,ny));
                    board[nh][nx][ny] = board[tmp.h][tmp.x][tmp.y] + 1;

                }
            }
        }
    }
}