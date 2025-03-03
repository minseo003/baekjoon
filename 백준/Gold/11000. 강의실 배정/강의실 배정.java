import java.util.*;
import java.io.*;


class Main {

    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, (o1, o2) ->
        {return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(lectures[0][1]);

        for (int i = 1; i < n; i++) {
            if (lectures[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(lectures[i][1]);
        }
        bw.write(pq.size() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}