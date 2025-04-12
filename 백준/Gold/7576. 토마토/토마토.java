import java.util.*;
import java.io.*;

class Tomato {
    int x;
    int y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static int m,n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static Queue<Tomato> queue = new LinkedList<>();
    static boolean flag = false;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) queue.offer(new Tomato(i,j));
                if(board[i][j] == 0) flag = true;
            }
        }
        bfs();

        int answer = 0;
        boolean zeroLeft = false;
        for (int i = 0; i < n; i++) {
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 0) {
                    answer = -1;
                    zeroLeft = true;
                    break;
                }
                answer = Math.max(board[i][j]-1, answer);
            }
            if(zeroLeft) break;
        }
        if(!flag) answer = 0;


        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs() {

        while(!queue.isEmpty()) {
             Tomato t = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = board[t.x][t.y] + 1;
                    queue.offer(new Tomato(nx,ny));
                }
            }
        }
    }
}