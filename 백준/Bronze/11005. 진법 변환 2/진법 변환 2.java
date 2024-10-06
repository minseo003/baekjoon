import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sar = br.readLine().split(" ");
        int n = Integer.parseInt(sar[0]);
        int b = Integer.parseInt(sar[1]);

        List<Character> lst = new ArrayList<>();

        while (n > 0) {
            if(n%b < 10)
                lst.add((char)(n%b + '0'));
            else
                lst.add((char)(n%b  - 10 + 'A'));
            n /= b;
        }

        for (int i = lst.size() - 1; i >= 0; i--) {
            System.out.print(lst.get(i));
        }
    }

}