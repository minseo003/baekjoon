import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        br.close();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;
        int answer = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    tmp = arr[i] + arr[j] + arr[k];
                    if(tmp > answer && tmp <= m) answer = tmp;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}