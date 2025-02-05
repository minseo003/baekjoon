import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static boolean[] ch;
    static ArrayList<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0,m);
        bw.write(sb.toString() + " \n");
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int start, int depth, int m) {

        Set<Integer> hashSet = new HashSet<>();  // 같은 depth 내 중복 방지

        if (depth == m) {
            for (int x : tmp) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length ; i++) {

            if (!ch[i] && !hashSet.contains(arr[i])) {

                ch[i]= true;
                hashSet.add(arr[i]);
                tmp.add(arr[i]);
                dfs(i + 1, depth + 1, m);
                ch[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}