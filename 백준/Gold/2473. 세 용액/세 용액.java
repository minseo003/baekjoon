import java.util.*;
import java.io.*;


class Main {

    static Long[] arr;
    static long closestSum = Long.MAX_VALUE;
    static long ans1 = 0, ans2 = 0, ans3 = 0;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        solution();
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solution() {

        for (int i = 0; i < arr.length - 2; i++) {
            int lt = i+1 , rt = arr.length - 1;

            while (lt < rt) {
                long sum = arr[i] + arr[lt] + arr[rt];

                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                    ans1 = arr[i];
                    ans2 = arr[lt];
                    ans3 = arr[rt];
                }

                if(sum < 0) lt++;
                else rt--;
            }
        }
        sb.append(ans1 + " " + ans2 + " " + ans3 + " ");
        sb.append("\n");
    }
}