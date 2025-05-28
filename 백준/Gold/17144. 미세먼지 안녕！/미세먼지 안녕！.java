import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static int r,c,t;
    static List<Integer> airCleanerRows = new ArrayList<>();
    static int sumOfDust = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[r][c];

        for(int i = 0 ; i < r; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < c ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumOfDust += arr[i][j];

                if (arr[i][j] == -1) {
                    airCleanerRows.add(i);
                }
            }

        }
        solution();
    }

    static void solution() {
        while (t-- > 0) {
            arr = spreadDust();
            executeAirCleaner();
        }
        System.out.println(calculateSum());
    }

    static int[][] spreadDust() {
        int[][] temp = new int[r][c];

        for(int i = 0 ; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                temp[i][j] += arr[i][j];

                for(int x = 0 ; x < 4 ; x++) {
                int nx = i + dx[x];
                int ny = j + dy[x];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if(arr[nx][ny] == -1) continue;

                temp[nx][ny] += (arr[i][j]/5);
                temp[i][j] -= (arr[i][j]/5);
                }
            }
        }
        return temp;
    }

    static void executeAirCleaner() {
        int top = airCleanerRows.get(0);

        for (int x = top - 1; x > 0; x--) {
            arr[x][0] = arr[x-1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            arr[0][y] = arr[0][y+1];
        }

        for (int x = 0; x < top; x++) {
            arr[x][c-1] = arr[x+1][c-1];
        }

        for (int y = c - 1; y > 1; y--) {
            arr[top][y] = arr[top][y-1];
        }

        arr[top][1] = 0;

        int bottom = airCleanerRows.get(1);

        for (int x = bottom + 1; x < r - 1; x++) {
            arr[x][0] = arr[x+1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            arr[r-1][y] = arr[r-1][y+1];
        }

        for (int x = r - 1; x > bottom; x--) {
            arr[x][c-1] = arr[x-1][c-1];
        }

        for (int y = c - 1; y > 1; y--) {
            arr[bottom][y] = arr[bottom][y-1];
        }

        arr[bottom][1] = 0;
    }

    static int calculateSum() {
        int sum = 2;

        for(int i = 0 ; i < r; i++) {
            for(int j = 0 ; j < c ; j++) {
            sum += arr[i][j];
            }
        }
        return sum;
    }
}