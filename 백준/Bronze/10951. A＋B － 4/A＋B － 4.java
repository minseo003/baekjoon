import java.util.*;

class Main {

    public List<Integer> solution(List<Integer> al) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < al.size() - 1; i++) {
            list.add(al.get(i) + al.get(i + 1));
            i++;
        }
        return list;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        List<Integer> al = new ArrayList<>();

        while (kb.hasNext()) {
            al.add(kb.nextInt());
        }

        for (int x : T.solution(al)) {
            System.out.println(x);
        }

    }

}
