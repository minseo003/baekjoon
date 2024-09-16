import java.util.*;

class Main {
    int[] arr = new int[2];
    public int[] solution(int h, int m) {
        if (m < 45) {
            if (h == 0) h = 23;
            else h -= 1;
            m += 15;
        } else {
            m -= 45;
        }
        arr[0] = h;
        arr[1] = m;
        return arr;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int h = kb.nextInt();
        int m = kb.nextInt();

        for (int x : T.solution(h, m)) {
            System.out.print(x + " ");
        }
    }

}
