import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static boolean[] ch;
    static int[] parent;
    static Queue<Integer> queue = new LinkedList<>();

    static void bfs() {
        queue.offer(1);
        ch[1] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int o : list.get(x)) {
                if (!ch[o]) {
                    queue.add(o);
                    ch[o] = true;
                    parent[o] = x;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ch = new boolean[n+1];
        parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        bfs();

        for (int i = 2; i < parent.length; i++) {
            bw.write(parent[i] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
