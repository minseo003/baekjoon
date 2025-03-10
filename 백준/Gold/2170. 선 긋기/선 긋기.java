import java.util.*;
import java.io.*;

class line implements Comparable<line>{
    int start;
    int end;

    public line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(line o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else {
            return this.start - o.start;
        }
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<line> lines = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            lines.add(new line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(lines);
        int start = lines.get(0).start;
        int end = lines.get(0).end;
        int len = end - start;

        for(int i = 1 ; i < n ; i++) {
            if(start <= lines.get(i).start && end >= lines.get(i).end) {
                continue;
            } else if(lines.get(i).start < end) {
                len += lines.get(i).end - end;
            } else {
                len += lines.get(i).end - lines.get(i).start;
            }
            start = lines.get(i).start;
            end = lines.get(i).end;
        }

        bw.write(len + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}