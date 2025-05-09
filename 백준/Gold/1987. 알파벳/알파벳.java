import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Set<Character> set = new HashSet<>();
    static int r,c;
    static char[][] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for(int i = 0 ; i < r ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < c ; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        set.add(arr[0][0]);
        dfs(0,0,1);
        bw.write(max + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int count) {
        max = Math.max(max, count);


        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < r && ny >= 0 && ny < c) {
                if(!set.contains(arr[nx][ny])) {
                    set.add(arr[nx][ny]);
                    dfs(nx,ny,count+1);
                    set.remove(arr[nx][ny]);
                }
            }
        }
    }
}