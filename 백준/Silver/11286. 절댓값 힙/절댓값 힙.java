import java.util.*;
import java.io.*;


class num implements Comparable<num> {
    int x;
    int y;
    
    public num(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(num o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
    
}
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<num> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp != 0) {
                queue.offer(new num(Math.abs(tmp), tmp));
            } else {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll().y).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}