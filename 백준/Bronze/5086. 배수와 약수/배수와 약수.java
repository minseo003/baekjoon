import java.util.*;
import java.io.*;

class Main {

    public List<String> solution(List<Integer> lst) {
        List<String> slit = new ArrayList<>();

        for(int i=0;i<lst.size();i++) {
            if(lst.get(i) % lst.get(i+1) == 0) slit.add("multiple");
            else if(lst.get(i+1) % lst.get(i) == 0) slit.add("factor");
            else slit.add("neither");

            i++;
        }
        return slit;
    }

    public static void main(String[] args) throws Exception{
        Main T = new Main();
        List<Integer> lst = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null) {
            String[] sar = input.split(" ");
            if (Integer.parseInt(sar[0]) != 0) {
                lst.add(Integer.parseInt(sar[0]));
                lst.add(Integer.parseInt(sar[1]));
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String s : T.solution(lst)) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

}