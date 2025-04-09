import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};
    static int w,h;
    static int[][] board;
    static boolean[][] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            board = new int[h][w];
            ch = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(board[i][j] == 1 && !ch[i][j]) {
                        dfs(i,j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void dfs(int i, int j) {
        ch[i][j] = true;

        for (int x = 0; x < 8; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (!ch[nx][ny] && board[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }

    }

}