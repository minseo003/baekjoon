import java.util.*;

class Main {

    public int[] solution(List<Integer> arr) {
        int[] ch = {1, 1, 2, 2, 2, 8};
        int[] result = new int[6];

        for (int i = 0; i < ch.length; i++) {
            result[i] = ch[i] - arr.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        while (kb.hasNext()) {
            arr.add(kb.nextInt());
        }
        for (int x : T.solution(arr)) {
            System.out.print(x + " ");
        }
    }

}