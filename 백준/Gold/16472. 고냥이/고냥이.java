import java.util.*;
import java.io.*;

class Main {

    static int n;
    static int answer = Integer.MIN_VALUE;
    static Map<Character, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        bw.write(solution(str) + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static int solution(String str) {
        int lt = 0;

        for (int rt = 0; rt < str.length(); rt++) {
            char c = str.charAt(rt);
            map.put(c,map.getOrDefault(c,0) + 1);

            while (map.size() > n) {
                char left = str.charAt(lt);
                map.put(left,map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                lt++;
            }
            answer = Math.max(answer,rt - lt + 1);
        }
        return answer;
    }
}