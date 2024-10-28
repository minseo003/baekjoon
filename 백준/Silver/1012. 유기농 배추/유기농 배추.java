import java.util.*;
import java.io.*;
class Main {

    static int answer;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int n,m;

    public void dfs(int x, int y, int[][] arr) {
        for(int i = 0; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                dfs(nx,ny,arr);
            }
        }
    }

    public int solution(int[][] arr) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                    answer++;
                    dfs(i,j,arr);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main T  = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int j = 0; j < t; j++) {
            answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken()); //배추밭의 가로길이
            n = Integer.parseInt(st.nextToken()); //배추밭의 세로길이
            int k = Integer.parseInt(st.nextToken()); //배추가 심어져있는 위치의 개수
            int[][] arr = new int[n][m];  //2차원 배열 초기화

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken()); // 0 - m-1
                int b = Integer.parseInt(st.nextToken()); // 0 - n-1
                arr[b][a] = 1;
            }
            System.out.println(T.solution(arr));
        }
    }
}