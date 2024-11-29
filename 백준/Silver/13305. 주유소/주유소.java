import java.util.*;
import java.io.*;


public class Main {

    static int N;
    static int[] city;
    static int[] dis;
    static long answer = 0;

    static long solution() {
        long minCost = city[0];

        for(int i = 0 ; i < N-1; i++) {
            if (city[i] < minCost) {
                minCost = city[i];
            }
            answer += (minCost * dis[i]);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        city = new int[N];
        dis = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < city.length; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }
}