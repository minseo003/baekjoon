import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int min = 256;
        int max = 0;

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < m ; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
                if(min > arr[i][j]) min = arr[i][j];
                if(max < arr[i][j]) max = arr[i][j];
            }
        }

        int time = 99999999;
        int high = 0;

        for(int i = min ; i <= max ; i++) {
            int count = 0;
            int block = b;

            for(int j = 0 ; j < n ; j++) {
                for(int k = 0 ; k < m ; k++) {

                    if(i < arr[j][k]) {
                        count += ((arr[j][k] - i) * 2);
                        block += (arr[j][k] - i);
                    } else {
                        count += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }
            if(block < 0) break;

            if(time >= count) {
                time = count;
                high = i;
            }
        }
        bw.write(time + " " + high + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
