import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[6];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tmp = 0;
        for(int x : arr) {
            tmp += (x + t - 1) / t;
        }
        sb.append(tmp).append('\n');
        sb.append(N/p).append(' ').append(N%p).append('\n');
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}