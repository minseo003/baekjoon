import java.util.*;
import java.io.*;
class Main {
    static ArrayList<Integer> size  = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n;
    static int tmp = 0;

    public void dfs(int i, int j, int[][] arr) {
        for(int x = 0; x < 4; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                tmp++;
                dfs(nx,ny,arr);
            }
        }

    }

    public int solution(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    answer++;
                    tmp++;
                    arr[i][j] = 0;
                    dfs(i,j,arr);
                    size.add(tmp);
                    tmp = 0;
                }

            }
        }
        return answer;
    }

    public static void main(String [] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for(int j = 0; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(T.solution(arr) + "\n");
        Collections.sort(size);
        for(int x : size) bw.write(x + "\n");
        bw.flush();
        bw.close();
    }
}