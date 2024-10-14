import java.util.*;
import java.io.*;

class Main {

    public int solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int x : arr) {
            if(x != 0) stack.push(x);
            else stack.pop();
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       int[] arr = new int[n];
       for(int i=0;i<n;i++) {
           arr[i] = Integer.parseInt(br.readLine());
       }
       System.out.print(T.solution(arr));
   }
}