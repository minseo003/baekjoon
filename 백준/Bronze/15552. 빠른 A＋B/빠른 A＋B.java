import java.io.*;

class Main {

    public int[] solution(int[][] arr) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i] += arr[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            String[] sar = str.split(" ");
            for (int j = 0; j < sar.length; j++) {
                arr[i][j] = Integer.parseInt(sar[j]);
            }
        }
        for (int x : T.solution(arr)) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }

}