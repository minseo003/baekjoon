import java.io.*;
import java.util.*;

class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int n;
    static boolean[] ch;

    static void dfs(int r) {

        ch[r] = true;
        System.out.print(r + " ");

        for(int x : list.get(r)) {
            if(!ch[x]) {
                dfs(x);
            }
        }
    }

    static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        System.out.print(r + " ");
        ch[r] = true;

        while(!queue.isEmpty()) {
            for(int x : list.get(queue.poll())) {
                if(!ch[x]) {
                    queue.offer(x);
                    System.out.print(x + " ");
                    ch[x] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= n ; i++ ) { //초기화
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1 ; i <= n; i++) {
            Collections.sort(list.get(i));  //오름차순 정렬
        }

        ch = new boolean[n+1];
        dfs(r);
        System.out.println();
        ch = new boolean[n+1];
        bfs(r);
    }

}