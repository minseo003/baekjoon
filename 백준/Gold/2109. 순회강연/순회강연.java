import java.util.*;
import java.io.*;

class c implements Comparable<c>{
    int p;
    int d;
    public c(int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(c o) {
        return this.d - o.d;
    }

}

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        List<c> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list.add(new c(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        
        Collections.sort(list);
        
        for(c lec : list) {
            queue.offer(lec.p);
            if(queue.size() > lec.d) {
                queue.poll();
            }
        }
        int answer = 0;
        while(!queue.isEmpty()) answer += queue.poll();
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}