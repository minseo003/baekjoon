import java.util.*;
import java.io.*;


class Main {
    static int N;

    public static int solution(int n) {
        for (int i = 0; i < n; i++) {
            int x = i;
            int tmp = 0;
            while (!(x == 0)) {
                tmp += x%10;
                x = x/10;
            }
            if ((n - i) == tmp) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        br.close();
        bw.write(solution(N) + " \n");
        bw.flush();
        bw.close();
    }
}