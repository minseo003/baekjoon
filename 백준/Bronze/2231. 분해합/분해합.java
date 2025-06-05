import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            int number = i;
            int sum = 0;

            while(number != 0) {  //각 자릿수 더하기
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}