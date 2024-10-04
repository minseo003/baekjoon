import java.util.*;

class Main {


    public static void main(String[] args) {
        Queue q = new LinkedList<>();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i=1;i<=n;i++) {
            q.offer(i);
        }
        while(q.size()!=1) {
            q.poll();
            q.offer(q.poll());
        }
        System.out.print(q.poll());
    }
}