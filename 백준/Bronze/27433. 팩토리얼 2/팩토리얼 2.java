import java.util.*;

class Main {

    public Long Factorial(int n) {
        if(n == 0) return 1L;
        if(n == 1) return 1L;
        return n * Factorial(n-1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.print(T.Factorial(n));
    }
}