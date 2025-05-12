import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);

        int rank = 0;
        for(int i = 0 ; i < n ; i++) {
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i],rank);
                rank++;
            }
        }

        for(int x : arr) {
            sb.append(map.get(x)).append(' ');
        }
        bw.write(sb + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}