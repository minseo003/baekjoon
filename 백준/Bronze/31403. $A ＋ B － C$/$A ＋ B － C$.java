import java.util.*;
import java.io.*;


class Main {

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                String a = br.readLine();
                String b = br.readLine();
                String c = br.readLine();

                bw.write(num(Integer.parseInt(a),Integer.parseInt(b),Integer.parseInt(c)) + "\n");
                bw.write(str(a,b,c) + "\n");
                br.close();
                bw.flush();
                bw.close();

        }

        static int num(int a, int b, int c) {
                return a + b - c;
        }

        static int str(String a, String b, String c) {
                String tmp = a + b;
                return Integer.parseInt(tmp) - Integer.parseInt(c);
        }
}