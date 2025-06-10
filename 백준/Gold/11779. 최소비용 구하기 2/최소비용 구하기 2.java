import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int e;
    int cost;

    public Node(int e, int cost) {
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node n) {
        return this.cost - n.cost;  //cost를 기준으로 오름차순
    }
}

class Main {

    static ArrayList<Node>[] list;
    static int n,m, start, end;
    static int[] dist;
    static int[] route;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        route = new int[n+1];
        Arrays.fill(dist,1000000001);
        visited = new boolean[n+1];
        dijkstra();

        System.out.println(dist[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;

        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());

        for(int i = routes.size() - 1 ; i >= 0 ; i--) {
            System.out.print(routes.get(i) + " ");
        }

    }

    static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        dist[start] = 0;
        route[start] = 0;

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(!visited[current.e]) visited[current.e] = true;
            else continue;

            for(int i = 0 ; i < list[current.e].size(); i++) {
                Node next = list[current.e].get(i);

                if(dist[next.e] > dist[current.e] + next.cost) {
                    dist[next.e] = dist[current.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = current.e;
                }
            }
        }
    }
}