import java.io.*;
import java.util.*;


class Main {

    static class cor {
        int x,y;

        public cor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] arr;
    static boolean[][] ch;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    static int n,m;
    static Queue<cor> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        ch = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'I') {
                    queue.offer(new cor(i,j));
                    ch[i][j] = true;
                }
            }
        }
        bfs();
        if(answer == 0) {
            bw.write("TT" + "\n");
        }else {
            bw.write(answer + "\n");
        }
        br.close();
        bw.flush();
        bw.close();


    }

    static void bfs() {

        while(!queue.isEmpty()) {

            cor tmp = queue.poll();
            if(arr[tmp.x][tmp.y] == 'P') answer++;

            for(int i = 0 ; i < 4 ; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!ch[nx][ny] && arr[nx][ny] != 'X') {
                        queue.offer(new cor(nx,ny));
                        ch[nx][ny] = true;
                    }
                }
            }
        }
    }
}