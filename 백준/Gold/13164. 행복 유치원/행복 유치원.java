import java.util.*;
import java.io.*;


class Main {

    static int n,k;
    static int[] arr;
    static int[] cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cost = new int[n-1];
        st = new StringTokenizer(br.readLine()," ");
        int answer = 0;

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);  //오름차순 정렬
        
        for(int i = 0 ; i < n - 1 ; i++) {
            cost[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(cost);

        for (int i = 0; i < n - k; i++) {
            answer += cost[i];
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}