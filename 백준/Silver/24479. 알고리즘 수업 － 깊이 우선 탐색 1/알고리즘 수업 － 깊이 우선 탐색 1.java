import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean ch[];
    static int result[];
    static int cnt = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        result = new int[n+1];
        ch = new boolean[n+1];

        for(int i = 0; i <= n; i++ ) {
            list.add(new ArrayList<Integer>());
        }
        String input = "";
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(ArrayList<Integer> x : list) {
            Collections.sort(x);
        }
        
        ch[r] = true;
        result[r] = cnt++;
        dfs(r);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 1; i <= n ;i++ ) {
            bw.write(result[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void dfs(int r) {

        for(int x : list.get(r)) {
            if(!ch[x]) {
                ch[x] = true;
                result[x] = cnt++;
                dfs(x);
            }
        }
    }
}