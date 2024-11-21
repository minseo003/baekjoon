import java.util.*;
import java.io.*;


class Main {

    static int N;
    static int[] P;
    static int answer = 0;
    static int tmp = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < N ; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);  //오름차순 정렬
        for(int i = 0; i < N ; i++) {
            tmp = 0;
            for(int j = 0; j <= i; j++) {
                tmp += P[j];
            }
            answer += tmp;
        }
        bw.write(answer + " ");
        br.close();
        bw.flush();
        bw.close();
    }
}