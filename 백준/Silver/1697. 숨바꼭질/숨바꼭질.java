import java.util.*;

class Main {

    static int N,K;
    static int[] dx = {1,-1,2};
    static int[] dist;
    static boolean[] ch;

    static void bfs(int n, int k){
        int nx = 0;
        Queue<Integer> queue = new LinkedList<>();

        ch[n] = true;
        queue.offer(n);
        dist[n] = 0;

        while (!queue.isEmpty()) {

            int tmp = queue.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    nx = tmp * dx[i];
                } else {
                    nx = tmp + dx[i];
                }

                if (nx >= 0 && nx <= 100000 && ch[nx] == false) {
                    ch[nx] = true;
                    dist[nx] = dist[tmp] + 1;
                    queue.offer(nx);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String[] s = kb.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        ch = new boolean[100001];
        dist = new int[100001];
        bfs(N,K);
        System.out.println(dist[K]);
    }

}