import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int answer = 0;

        for(int rt = 0; rt < n ; rt++) {

            map.put(arr[rt], map.getOrDefault(arr[rt],0) + 1);

            while(map.size() > 2) {
                map.put(arr[lt],map.get(arr[lt]) - 1);
                if(map.get(arr[lt]) == 0) {
                    map.remove(arr[lt]);
                }
                lt++;
            }
            answer = Math.max(answer , rt - lt + 1);
        }
        bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}