import java.util.*;

class Main {
    public Integer solution(int n, int k) {
        List<Integer> lst = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if(n % i == 0) lst.add(i);
        }
        if(lst.size() < k) return 0;
        return lst.get(k-1);
    }

    public static void main(String[] args) throws Exception {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.print(T.solution(n, k));
    }
}