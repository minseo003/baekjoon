import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        long tmp = (long) a * b * c;
        String str = String.valueOf(tmp);

        for(char i = '0' ; i <= '9' ; i++) {
            map.put(i, 0);
        }

        for(int i = 0 ; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }

        for(int x : map.values()) {
            sb.append(x).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}