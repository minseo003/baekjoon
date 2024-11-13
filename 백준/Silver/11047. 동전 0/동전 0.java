import java.util.*;
import java.io.*;

class Main {

    static int N,K,answer = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) {  //arr 초기화
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                answer += K / arr[i];
                K = K % arr[i];
            }
        }
        System.out.println(answer);
    }
}