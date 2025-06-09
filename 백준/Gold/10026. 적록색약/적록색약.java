import java.io.*;
import java.util.*;

class Main {

    static int n;
    static char[][] board;
    static boolean[][] ch;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        ch = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++) {
                board[i][j] = s.charAt(j);

            }
        }
        int answer1 = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!ch[i][j]){
                dfs(i,j,board[i][j]);
                answer1++;
                }
                if(board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }

        ch = new boolean[n][n];
        int answer2 = 0;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!ch[i][j]) {
                    dfs(i,j,board[i][j]);
                    answer2++;
                }
            }
        }
        bw.write(answer1 + " " + answer2 + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int i, int j, char target) {
        if(ch[i][j]) {
            return;
        }

        ch[i][j] = true;

        for(int x = 0 ; x < 4 ; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == target) {
                dfs(nx, ny, target);
            }
        }
    }

}