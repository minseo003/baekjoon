import java.util.*;
import java.io.*;

public class Main {

    static int K;

    static boolean bfs(ArrayList<ArrayList<Integer>> graph, int start, int[] ch) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        ch[start] = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            for (int x : graph.get(tmp)) {

                if (ch[x] == -1) {
                    ch[x] = 1 - ch[tmp];
                    queue.offer(x);
                } else {
                    if (ch[x] == ch[tmp]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int v;
        int e;
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            int[] ch = new int[v+1];
            for (int k = 0; k <= v; k++) {
                graph.add(new ArrayList<Integer>());
                ch[k] = -1;  //방문하지 않은 상태
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            boolean answer = true;
            for (int s = 1; s <= v; s++) {
                if (ch[s] == -1 && !bfs(graph, s, ch)) {
                    answer = false;
                    break;
                }
            }
            bw.write(answer ? "YES\n" : "NO\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}