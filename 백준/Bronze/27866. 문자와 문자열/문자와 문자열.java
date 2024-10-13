import java.util.*;

class Main {

   public static void main(String[] args) {
       Main T = new Main();
       Scanner kb = new Scanner(System.in);
       String s = kb.next();
       int n = kb.nextInt();
       System.out.println(T.solution(s, n));
   }

   public Character solution(String s, int n) {
       char[] c = s.toCharArray();
       return c[n-1];
   }

}