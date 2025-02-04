import java.util.*;
import java.io.*;

class Main {

    static ArrayList<String> list = new ArrayList<>();
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        for (String s : list) {
            solution(s);
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solution(String s) {
        int lt  = 0;
        int rt = s.length() - 1;

        while (lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                if (isPalindrome(s, lt + 1, rt) || isPalindrome(s, lt, rt - 1)) {
                    sb.append(1);
                    sb.append("\n");
                    return;
                } else {
                    sb.append(2);
                    sb.append("\n");
                    return;
                }
            }
            lt++;
            rt--;
        }
        sb.append(0);
        sb.append("\n");
    }

    static boolean isPalindrome(String s, int lt, int rt) {
        while (lt < rt) {
            if (s.charAt(lt) != s.charAt(rt)) {
                return false;
            }
            lt++;
            rt--;
        }
        return true;
    }
}