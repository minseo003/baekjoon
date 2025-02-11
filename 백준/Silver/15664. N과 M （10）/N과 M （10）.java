import java.util.*;
import java.io.*;

class Main {

    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] arr;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new boolean[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0,m);
        System.out.print(sb.toString());
    }


    static void dfs(int start, int depth, int m) {

        Set<Integer> hash = new HashSet<>();

        if (depth == m) {
            for (int x : answer) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }

        for (int i = start; i < arr.length; i++) {
            if (!ch[i] && !hash.contains(arr[i])) {
                ch[i] = true;
                hash.add(arr[i]);
                answer.add(arr[i]);
                dfs(i + 1, depth + 1, m);
                ch[i] = false;
                answer.remove(answer.size() - 1);
            }
        }
    }
}