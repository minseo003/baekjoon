import java.util.*;
import java.io.*;

class Main {

    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    static void cal(String key, int value) {
        if (key.equals("push")) {
            stack.push(value);
        } else if (key.equals("pop")) {
            if (stack.size() == 0) {
                answer.add(-1);
            } else {
                answer.add(stack.pop());
            }
        } else if (key.equals("size")) {
            answer.add(stack.size());
        } else if (key.equals("empty")) {
            answer.add(stack.size() == 0 ? 1 : 0);
        } else if (key.equals("top")) {
            answer.add(stack.size() == 0 ? -1 : stack.peek());
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String key = st.nextToken();
            if (key.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                cal(key, value);
            } else {
                cal(key, 0);
            }
        }

        for (int x : answer) {
            bw.write(x + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}