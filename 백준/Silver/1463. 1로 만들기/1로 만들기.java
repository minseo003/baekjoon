import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp;  //메모리제이션 할 배열

    static int solution(int x) {

        if (dp[x] == null) {

            if (x % 6 == 0) {  //3과 2로 모두 나누어지는 경우 최선의 방법을 도출
                dp[x] = Math.min(Math.min(solution(x/3),solution(x/2)),solution(x-1)) + 1;
            }
            else if (x % 3 == 0) {
                dp[x] = Math.min(solution(x/3),solution(x-1)) + 1;
            } else if (x % 2 == 0) {
                dp[x] = Math.min(solution(x/2),solution(x-1)) + 1;
            } else {
                dp[x] = solution(x-1) + 1;
            }
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];
        dp[0] = dp[1] = 0;
        System.out.print(solution(n));
    }
}