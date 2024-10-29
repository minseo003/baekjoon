import java.util.*;
import java.io.*;

class Main {

    static Stack<Integer> stack = new Stack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        boolean flag = false;
        String answer = "Nice";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = 1;
        int tmp = 0;
        for(int i = 0 ; i < n ; i++ ) {
            if (!stack.isEmpty() && stack.peek() == x) {
                queue.offer(stack.pop());
                x++;
            }
             else if ((tmp = Integer.parseInt(st.nextToken())) == x) {
                queue.offer(tmp);
                x++;
            }  else {
                stack.push(tmp);
            }
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        x = 1;
        for (int i = 0; i < queue.size(); i++) {
            if(queue.poll() != x) flag = true;
            x++;
        }
        if(flag) answer = "Sad";
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

}