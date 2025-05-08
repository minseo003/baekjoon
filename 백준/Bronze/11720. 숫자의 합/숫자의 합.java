import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for(int i = 0; i < n ; i++) {
            answer += str.charAt(i) - '0';
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}