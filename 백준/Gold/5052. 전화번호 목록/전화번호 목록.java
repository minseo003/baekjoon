import java.util.*;
import java.io.*;


class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneBook = new String[n];
            for(int j = 0 ; j < n ; j++) {
                phoneBook[j] = br.readLine();
            }
            Arrays.sort(phoneBook);
            bw.write(solution(phoneBook) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static String solution(String[] phoneBook) {
        for(int i = 0 ; i < phoneBook.length - 1; i++) {
            if(phoneBook[i+1].startsWith(phoneBook[i])) {
                return "NO";
            }
        }
        return "YES";
    }
}