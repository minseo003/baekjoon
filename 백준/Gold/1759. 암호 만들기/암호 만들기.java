import java.util.*;
import java.io.*;


class Main {

    static char[] arr;
    static boolean[] ch;
    static Set<Character> hash = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        hash.add('a');
        hash.add('e');
        hash.add('o');
        hash.add('i');
        hash.add('u');

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        ch = new boolean[c];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < c ; i++) {
            arr[i]  = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs("",0,0,0,l);
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();

    }


    static void dfs(String str, int xCnt, int yCnt, int start, int l) {

        if (str.length() == l) {
            if (xCnt >= 2 && yCnt >= 1) {
                sb.append(str + "\n");
            }
            return;
        }

        for(int i = start ; i < arr.length ; i++) {

            if (!ch[i]) {

                ch[i] = true;
                if (hash.contains(arr[i])) {
                    yCnt++;
                }else xCnt++;
                dfs(str + arr[i], xCnt, yCnt,i+1 , l);
                ch[i] = false;
                if (hash.contains(arr[i])) {
                    yCnt--;
                } else xCnt--;
            }
        }
    }
}
