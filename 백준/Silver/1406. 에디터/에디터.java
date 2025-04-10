import java.util.*;
import java.io.*;


class Main {

    static Stack<String> leftStack = new Stack<>();
    static Stack<String> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        for(int i = 0; i < str.length; i++) {
            leftStack.push(str[i]);
        }

        int m = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            if (s.equals("P")) {
                leftStack.push(st.nextToken());
            } else if (s.equals("L")) {
                if(!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else if (s.equals("D")) {
                if(!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            }else {
                if(!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}