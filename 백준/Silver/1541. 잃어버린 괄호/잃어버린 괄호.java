import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] string = br.readLine().split("-");
        String[] addNum = string[0].split("\\+");

        for (int i = 0; i < addNum.length; i++) {
            answer += Integer.parseInt(addNum[i]);
        }

        for(int i = 1 ; i < string.length ; i++) {
            String[] subNum = string[i].split("\\+");
            for(int j = 0 ; j < subNum.length ; j++) {
                answer -= Integer.parseInt(subNum[j]);
            }
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}