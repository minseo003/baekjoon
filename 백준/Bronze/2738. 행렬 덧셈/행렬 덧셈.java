import java.util.*;
import java.io.*;

class Main {

    public int[][] solution(int[][] arr) {
        int n = arr.length/2;
        int[][] answer = new int[n][arr[0].length];

        for(int i=0;i<n;i++) {
            for(int j=0;j<arr[0].length;j++) {
                answer[i][j] = arr[i][j] + arr[i+n][j];
            }
        }
        return answer;
    }
    public static void main(String[] agrs) throws Exception{

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sar = br.readLine().split(" ");
        int[][] arr = new int[Integer.parseInt(sar[0])*2][Integer.parseInt(sar[1])];
        int j = 0;
        String input = "";
        while((input = br.readLine()) != null) {
            String[] s = input.split(" ");
            for(int i=0;i<s.length;i++) {
                arr[j][i] = Integer.parseInt(s[i]);
            }
            j++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int[] x: T.solution(arr)) {
            for(int y : x) {
                bw.write(y + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

}