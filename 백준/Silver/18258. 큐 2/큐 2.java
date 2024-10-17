import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] queue = new int[n*2];
        int front = 0;
        int rear = -1;

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            if(s[0].equals("push")) queue[++rear] = Integer.parseInt(s[1]);
            else if(s[0].equals("pop")) {
                if(rear - front + 1 == 0) bw.write(-1 + "\n");
                else {
                    bw.write(queue[front] + "\n");
                    queue[front++] = 0;
                }
            }
            else if(s[0].equals("size")) bw.write(rear-front+1 + "\n");
            else if(s[0].equals("empty")) {
                if(rear-front+1 == 0) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
            else if(s[0].equals("front")) {
                if(rear-front+1 == 0) bw.write(-1 + "\n");
                else bw.write(queue[front] + "\n");
            }
            else {
                if(rear-front+1 == 0) bw.write(-1 + "\n");
                else bw.write(queue[rear] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}