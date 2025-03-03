import java.util.*;
import java.io.*;


class Main {

    static StringBuilder sb = new StringBuilder();
    static Character[] arr;
    static boolean[] ch;
    static int l;
    static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException{
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new Character[c];
        ch = new boolean[c];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,new StringBuilder(),0,0);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int index, StringBuilder str, int xnum, int ynum) {

        if (str.length() == l && xnum >= 1 && ynum >= 2) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = index; i < arr.length; i++) {
            str.append(arr[i]);
            if (set.contains(arr[i])) {
                dfs(i + 1, str, xnum + 1, ynum);
            } else {
                dfs(i + 1, str, xnum, ynum + 1);
            }
            str.deleteCharAt(str.length() - 1);
        }
    }
}