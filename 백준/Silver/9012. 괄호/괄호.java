import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            boolean flag = false;
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j = 0 ; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                }else {
                    if(stack.isEmpty()) {
                        flag = true;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            if(!flag && stack.isEmpty()) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();

    }
}