import java.util.*;

class Main {

    public int solution(String str) {
        String[] alpha = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        

        for (int i = 0; i < alpha.length; i++) {
            if(str.contains(alpha[i])) str = str.replace(alpha[i], "0");
        }
        return str.length();
    }

    public static void main(String[] agrs) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }
}