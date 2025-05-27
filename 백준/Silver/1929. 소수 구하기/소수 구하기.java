import java.io.*;
import java.util.*;

class Main {

    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1];
        isPrime();

        for(int i = m ; i <= n; i++) {
            if(!arr[i]) System.out.println(i);
        }
    }

    static void isPrime() {
        arr[0] = arr[1] = true;
        for(int i = 2 ; i <= Math.sqrt(arr.length); i++) {

            if (arr[i]) continue;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }
    }
}