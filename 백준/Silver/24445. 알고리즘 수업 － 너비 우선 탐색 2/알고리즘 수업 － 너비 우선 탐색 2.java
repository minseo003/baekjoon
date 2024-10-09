import java.util.*;
import java.io.*;

class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] ch;
    static int[] result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        result = new int[n+1];

        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<Integer>());
        }

        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> alist = list.get(i);
            Collections.sort(alist,Collections.reverseOrder()); //내림차순 정렬
        }
        bfs(n,r);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int n, int r) {

        ch = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        queue.offer(r);  //첫 시작점을 큐에 넣는다
        ch[r] = true; //갔다고 체크
        result[r] = cnt++; //방문순서를 넣어주고 cnt를 증가시킨다(다음에 바로 쓸 수 있도록)

        while(!queue.isEmpty()) {
            int tmp = queue.poll();

            for(int x : list.get(tmp)) {
                if(!ch[x]) {
                    queue.offer(x);
                    ch[x] = true;
                    result[x] = cnt++;
                }
            }
        }
    }
}