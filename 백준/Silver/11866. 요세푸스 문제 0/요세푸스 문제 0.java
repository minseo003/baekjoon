import java.util.*;

class Main {
    public ArrayList<Integer> solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 1; i<=n ; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            cnt++;
            if(cnt == k) {
                list.add(x);
                cnt = 0;
            }
            else queue.offer(x);
        }
        return list;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.print("<");
        ArrayList<Integer> list = T.solution(n,k);
        for(int i = 0; i < list.size();i++) {
            if(i == list.size() - 1) System.out.print(list.get(i));
            else System.out.print(list.get(i) + ", ");
        }
        System.out.print(">");
    }
}