import java.io.*;
import java.util.*;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> alist = new ArrayList<>();
        String input = "";
        while ((input = br.readLine()) != null) {
            alist.add(input);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String x : alist) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }

}