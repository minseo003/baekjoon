import java.util.*;


class Node implements Comparable<Node>{
    int to, cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int sum = 0;
        int answer = 1;
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int a = r[0], b = r[1] , cost = r[2];
            nodes.get(a).add(new Node(b,cost));
            nodes.get(b).add(new Node(a,cost));
        }

        int[] dist = dijkstra(N, nodes, 1);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i] <= K) count++;
        }
        return count;
    }

    static int[] dijkstra(int N, ArrayList<ArrayList<Node>> graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        pq.add(new Node(start,0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.to, nowCost = cur.cost;

            if(dist[now] < nowCost) continue;

            for (Node next : graph.get(now)) {
                int newCost = nowCost + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to,newCost));
                }
            }
        }
        return dist;
    }
}