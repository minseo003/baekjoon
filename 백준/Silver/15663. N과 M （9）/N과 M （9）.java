import java.util.*;
import java.io.*;

class Main {

    static int[] arr;
    static boolean[] ch;
    static ArrayList<Integer> tmp = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, m);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int m) {
        Set<Integer> set = new HashSet<>();

        if(depth == m) {
            for (int x : tmp) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!ch[i] && !set.contains(arr[i])) {
                ch[i] = true;
                tmp.add(arr[i]);
                set.add(arr[i]);

                dfs(depth+1, m);

                ch[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}