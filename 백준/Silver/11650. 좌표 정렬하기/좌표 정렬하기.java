import java.util.*;
import java.io.*;


class point implements Comparable<point> {
    int x;
    int y;

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
class Main {

    static ArrayList<point> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new point(a,b));
        }
        Collections.sort(arr);
        for (point d : arr) {
            bw.write(d.x + " " + d.y + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}