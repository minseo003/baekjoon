import java.util.*;
import java.io.*;


class Main {

    static int n,k;
    static int[] arr;
    static int[] len;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        len = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);  //오름차순 정렬

        for (int i = 0; i < n - 1; i++) {
            len[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(len);
        for (int i = 0; i < n-k; i++) {
            answer += len[i];
        }

        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

}