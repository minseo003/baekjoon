import java.util.*;
import java.io.*;

class Main {

    static int I;
    static int[][] board;
    static boolean[][] ch;
    static Point start;
    static Point end;
    static int[] dx = {-1,-1,1,1,-2,-2,2,2};
    static int[] dy = {2,-2,2,-2,1,-1,1,-1};

    static void bfs(int len, Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        board[start.x][start.y] = 0;
        ch[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            if(ch[end.x][end.y] == true) break;
            Point tmp = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx >= 0 && nx < len && ny >= 0 && ny < len && ch[nx][ny] == false) {
                    ch[nx][ny] = true;
                    board[nx][ny] = board[tmp.x][tmp.y] + 1;
                    queue.offer(new Point(nx,ny));
                }
            }
        }
    }
    static class Point{
        int x,y;

        Point(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        I = Integer.parseInt(br.readLine());
        for (int i = 0; i < I; i++) {
            int tmp = Integer.parseInt(br.readLine());
            board = new int[tmp][tmp];
            ch = new boolean[tmp][tmp];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine()," ");
            end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            bfs(tmp,start,end);
            bw.write(board[end.x][end.y]+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}