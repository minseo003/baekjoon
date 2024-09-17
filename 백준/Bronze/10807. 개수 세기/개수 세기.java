import java.util.*;

class Main {

    public int solution(int[] arr, int v) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == v) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        int v = kb.nextInt();

        System.out.print(T.solution(arr, v));

    }

}