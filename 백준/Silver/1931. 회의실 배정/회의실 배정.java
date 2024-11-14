import java.util.*;
import java.io.*;

class Ocu implements Comparable<Ocu>{
    int start;
    int end;

    Ocu(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Ocu o) {
        if(this.end==o.end) return this.start - o.start;  //끝나는 시간이 같으면 시작시간으로 오름차순 정렬
        else return this.end - o.end;  //끝나는 시간으로 오름차순 정렬
    }
}

class Main {

    static int N;
    static ArrayList<Ocu> alist= new ArrayList<>();
    static int answer = 1;
    static int end;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            alist.add(new Ocu(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(alist);  //위에 정의해놓은대로 정렬함

        end = alist.get(0).end;

        for (int i = 1; i < N; i++) {
            if (end <= alist.get(i).start) {
                answer++;
                end = alist.get(i).end;
            }
        }
        System.out.println(answer);
    }
}