import java.util.*;
import java.io.*;

class Main {

    public String solution(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        for(char x : s.toCharArray()) {
            if(x=='(') stack.push(x);
            else if(stack.size() != 0) stack.pop();
            else return "NO";
        }
        if(stack.size() != 0) return "NO";
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<n;i++) {
            String s = br.readLine();
            bw.write(T.solution(s) + "\n");
        }
        bw.flush();
        bw.close();
    }
}