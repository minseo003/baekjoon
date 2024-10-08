import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
    static boolean ch[];
    static int result[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        result = new int[n+1];

        for(int i=0;i<=n;i++) {  //인접 리스트 초기화
            lst.add(new ArrayList<Integer>());
        }

        String input = "";
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        for (int i = 0; i <= n; i++) {
            ArrayList<Integer> p = lst.get(i);
            Collections.sort(p);
        }
        bfs(n,r);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(int n,int r) {
        int cnt = 1;

        ch = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r);
        ch[r] = true;
        result[r] = cnt++;

        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            for(int num : lst.get(tmp)) {
                if (!ch[num]) {
                    queue.add(num);
                    ch[num] = true;
                    result[num] = cnt++;
                }
            }
        }
    }


}