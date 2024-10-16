import java.util.*;
import java.io.*;

class Main {

    public String solution(String s) {
        String answer = "yes";
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for(char x : c) {
            if(x == '(') stack.push(x);
            else if(x == ')') {
                if(stack.size() != 0 && stack.peek() == '(') stack.pop();
                else return "no";
            }
            else if(x == '[') stack.push(x);
            else if(x == ']') {
                if(stack.size() != 0 && stack.peek() == '[') stack.pop();
                else return "no";
            }
        }
        if(stack.size() != 0) return "no";
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while((input = br.readLine()) != null) {
            if(input.equals(".")) continue;
            bw.write(T.solution(input) + "\n");
        }
        bw.flush();
        bw.close();
    }
}