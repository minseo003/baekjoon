import java.util.*;
import java.io.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            for(int i = 0 ; i < s.length() ; i++) {
                for(int j = 0 ; j < r ; j++) {
                    sb.append(s.charAt(i));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}