import java.util.*;

class Main {
    public int solution(int n, int s, int[] arr) {
        int lt = 0, rt = 0;
        int tmp = 0;
        int answer = Integer.MAX_VALUE;
        boolean flag = true;

        while (true) {
            if (tmp >= s) {
                while (tmp >= s) {
                    answer = Math.min(answer, rt-lt);
                    tmp -= arr[lt++];
                    flag = false;
                }
            } else{
                if(rt >= arr.length) break;
                tmp += arr[rt++];
            }
        }
        if(flag) return 0;
        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int s = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print(T.solution(n, s, arr));
    }

}
