import java.io.*;
import java.util.*;

class Main {

    public int solution(String[] sar) {
        int answer = 0;

        for (int i = 0; i < sar.length; i++) {
            Map<Character,Integer> map = new HashMap<>();
            boolean flag = true;
            char[] c = sar[i].toCharArray();
            for(int j = 0; j < c.length; j++) {
                if (map.containsKey(c[j]) && map.get(c[j]) != j - 1) {
                        flag = false;
                        break;
                }
                map.put(c[j], j);
            }
            if (flag) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] sar = new String[n];

        for(int i = 0; i < n; i++) {
            sar[i] = br.readLine();
        }
        System.out.print(T.solution(sar));
    }
}
