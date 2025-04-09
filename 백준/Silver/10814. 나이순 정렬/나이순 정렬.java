import java.util.*;
import java.io.*;

class parti implements Comparable<parti>{
    int age;
    String name;

    public parti(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(parti o) {
        return this.age - o.age;
    }

}

class Main {

    public static void main(String[] args) throws IOException{
        ArrayList<parti> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < n ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr.add(new parti(age,name));
        }
        
        Collections.sort(arr);
        for (parti p : arr) {
            bw.write(p.age + " " + p.name + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}