import java.util.*;

class Main {

    public int solution(int[] arr) {
        int[] ch = new int[arr.length];
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            if(arr[i] == 1) continue;
            for(int j = 2 ; j < arr[i] ; j++) {
                if(arr[i] % j == 0) flag = false;
            }
            if(flag) answer++;
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

        System.out.print(T.solution(arr));
    }

}