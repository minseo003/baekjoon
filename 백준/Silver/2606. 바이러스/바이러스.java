import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int n = 0;
    static boolean[] ch;


    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        ch[1] = true;
        int answer = 0;

        while(!queue.isEmpty()) {

            for(int x : list.get(queue.poll())) {
                if(ch[x] != true) {
                    queue.offer(x);
                    ch[x] = true;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ch = new boolean[n+1];
        for(int i = 0; i <= n ; i++ ) {  //링크드리스트 초기화, 0번 인덱스 사용하지 않음
            list.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        System.out.print(bfs());
    }

}