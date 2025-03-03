import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        int left, right = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else return o1[0] - o2[0];
        });

        int x = arr[0][0];
        int y = arr[0][1];
        int len = y-x;

        for(int i = 0; i < n; i++){
            if(x <= arr[i][0] && arr[i][1] <= y) { //포함된 경우
                continue;
            } else if(arr[i][0] < y) { //일부만 포함된 경우
                len += arr[i][1] - y;
            } else { //겹치는 부분이 없는 경우
                len += arr[i][1] - arr[i][0];
            }
            x = arr[i][0];
            y = arr[i][1];
        }
        bw.write((len) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}