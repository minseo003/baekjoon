import java.util.*;

class Main {

    public int solution(String str) {
        str = str.trim();
        String[] sar = str.split(" ");
        if(sar[0] == "") return 0;
        return sar.length;
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.print(T.solution(str));
    }


}