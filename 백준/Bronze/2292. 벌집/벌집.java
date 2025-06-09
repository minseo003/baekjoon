import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;  // 최소루트
        int range = 2;  // 임의값


        if(n == 1) {
            System.out.println(1);
        } else {
            while(range <= n) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    }
}