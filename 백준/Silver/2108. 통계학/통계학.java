import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        // -4000 ~ 4000을 제외한 수로 초기화
        int min = Integer.MAX_VALUE;
        int median = 10000;
        int mode = 10000;

        for(int i = 0 ; i < n ; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value + 4000]++;

            if(max < value) {
                max = value;
            }
            if(min > value) {
                min = value;
            }
        }

        int count = 0;
        int mode_max = 0;

        boolean flag = false;

        for(int i = min + 4000 ; i <= max + 4000 ; i++) {

            if(arr[i] > 0) {

                // 중앙값
                if(count < (n+1)/2) {
                    count += arr[i];
                    median = i - 4000;
                }

                // 최빈값
                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if(mode_max == arr[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double) sum/n));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max - min);
        
    }
}