import java.util.*;

class Main {

    public String solution(int a, int b) {
        if(a>b) return ">";
        else if(a<b) return "<";
        else return "==";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        System.out.println(T.solution(a,b));
    }

}
