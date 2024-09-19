import java.io.*;

class Main {

    public void solution(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[] info = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    info[0] = i+1;
                    info[1] = j+1;
                }
            }
        }
        System.out.println(max);
        for (int x : info) System.out.print(x + " ");
    }

    public static void main(String[] solution) throws Exception {
        Main T = new Main();
        int[][] arr = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < arr.length; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        T.solution(arr);
    }
}