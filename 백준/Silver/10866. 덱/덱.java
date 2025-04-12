import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            String s = st.nextToken();

            if(s.equals("push_back")) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            } else if(s.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(st.nextToken()));
            }else if(s.equals("pop_front")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                }else {
                    bw.write(deque.pollFirst() + "\n");
                }
            }else if(s.equals("pop_back")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                }else {
                    bw.write(deque.pollLast() + "\n");
                }
            }else if(s.equals("size")) {
                bw.write(deque.size() + "\n");
            }else if(s.equals("empty")) {
                if(deque.isEmpty()) {
                    bw.write(1 + "\n");
                } else bw.write(0 + "\n");
            }else if(s.equals("front")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                }else {
                    bw.write(deque.peekFirst() + "\n");
                }
            }else if(s.equals("back")) {
                if(deque.isEmpty()) {
                    bw.write(-1 + "\n");
                }else {
                    bw.write(deque.peekLast() + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}