import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = -1;

        for(int i = n/5 ; i >= 0 ; i--) {
            int rest = n - (5 * i);
            if(rest % 3 == 0) {
                count = i + (rest / 3);
                break;
            }
        }
        System.out.println(count);
    }
}