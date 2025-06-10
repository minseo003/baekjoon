import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        int max = 0;
        int min = 0;

        for(int i = 0 ; i < n ; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i]) {
                max = tree[i];
            }
        }

        while(min < max) { // 이분탐색

            int mid = (min + max) / 2;
            long sum = 0;

            for(int h : tree) {

                if (h - mid > 0) {
                    sum += (h - mid);
                }
            }

            if(sum < m) {
                max = mid;
            }

            else{
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}