import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        if(line.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
        String[] s = line.split(" ");
        System.out.println(s.length);
    }
}