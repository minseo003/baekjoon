import java.io.*;
import java.util.*;

class Main {

    public List<Integer> solution(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> alist = new ArrayList<>();

        for (int i = 0 ; i < arr.length ; i++ ) {
            if (arr[i][0] == 1) {
                stack.push(arr[i][1]);
            } else if (arr[i][0] == 2) {
                alist.add(stack.isEmpty() ? -1 : stack.pop());
            } else if (arr[i][0] == 3) {
                alist.add(stack.size());
            } else if (arr[i][0] == 4) {
                alist.add(stack.isEmpty() ? 1 : 0);
            } else if (arr[i][0] == 5) {
                alist.add(stack.isEmpty() ? -1 : stack.peek());
            }
        }
        return alist;
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            String[] sar = br.readLine().split(" ");
            if(sar.length == 2){
                arr[i][0] = Integer.parseInt(sar[0]);
                arr[i][1] = Integer.parseInt(sar[1]);
            }
            arr[i][0] = Integer.parseInt(sar[0]);
        }
        for(int x : T.solution(arr)) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }
}