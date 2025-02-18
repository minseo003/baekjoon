import java.util.*;
import java.io.*;


class Main {

    static int n,k;
    static int[] dx = {1,-1,2};
    static int[] dist = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        bw.write(dist[k] + "\n");
        br.close();
        bw.flush();
        bw.close();
    }


    static void bfs() {
        int nx = 0;
        visited[n] = true;
        queue.offer(n);
        dist[n] = 0;

        while(!queue.isEmpty()) {

            if(visited[k]) {
                break;
            }
            Integer cur = queue.poll();

            for(int i = 0 ; i < 3; i++) {
                if(i == 2) {
                    nx = cur * dx[i];
                }else {
                    nx = cur + dx[i];
                }

                if(nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    dist[nx] = dist[cur] + 1;
                    queue.offer(nx);
                }
            }
        }
    }
}