import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph  = new ArrayList<>();
    static int N,min = Integer.MAX_VALUE,answer = 1;

    static class info {
        int index, count;

        public info(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public void bfs(int st) {
        Queue<info> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.offer(new info(st,0));
        visited[st] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            info cur = queue.poll();
            for (int next : graph.get(cur.index)) {
                if (!visited[next]) {
                    result += cur.count + 1;
                    visited[next] = true;
                    queue.add(new info(next,cur.count+1));
                }
            }
        }
        if (result < min) {
            min = result;
            answer = st;
        }
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }
        for(int i=1;i<=N;i++) {
            T.bfs(i);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}