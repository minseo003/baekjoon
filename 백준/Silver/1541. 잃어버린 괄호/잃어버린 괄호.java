import java.util.*;
import java.io.*;


class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        while(sub.hasMoreTokens()) {
            int num = 0;
            StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");
            while(add.hasMoreTokens()) {
                num += Integer.parseInt(add.nextToken());
            }
            if(answer == Integer.MAX_VALUE) {
                answer = num;
            }else {
                answer -= num;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}