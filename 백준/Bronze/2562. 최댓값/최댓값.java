import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        int max = Integer.MIN_VALUE;
        int idx = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[9];
        for(int i = 0 ; i < 9 ; i++) {
            n[i] = Integer.parseInt(br.readLine());
        }

        for( int i = 0; i < n.length; i++) {
            if(n[i] > max) {
                max = n[i];
                idx = i + 1;
            }
        }
        System.out.println(max);
        System.out.print(idx);
    }
}