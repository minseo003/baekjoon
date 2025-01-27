import java.util.*;
import java.io.*;


class Main {

    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[] ch = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for (int i = 0; i < arr.size(); i++) {
            Collections.sort(arr.get(i));
        }

        dfs(v, ch);
        System.out.println(sb.toString());
        Arrays.fill(ch, false);
        sb = new StringBuilder();
        bfs(v,ch);
        System.out.println(sb.toString());
    }

    static void dfs(int v,boolean[] ch) {
        sb.append(v + " ");
        ch[v] = true;

        for(int x : arr.get(v)) {
            if(!ch[x]) {
                dfs(x,ch);
            }
        }
    }

    static void bfs(int v, boolean[] ch) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch[v] = true;
        sb.append(v + " ");

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int x : arr.get(tmp)) {
                if(!ch[x]) {
                    ch[x] = true;
                    sb.append(x + " ");
                    queue.offer(x);
                }
            }
        }
    }
}