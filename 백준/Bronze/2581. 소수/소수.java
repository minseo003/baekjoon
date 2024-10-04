import java.util.*;

class Main {
    public List<Integer> solution(int m, int n) {

        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        int sum = 0;
        int idx = Integer.MAX_VALUE;
        List<Integer> lst = new ArrayList<>();

        for(int i=2;i<=n;i++) {  //소수를 찾는 법
            if (arr[i] == 0)
                for(int j=i*2;j<=n;j=j+i) {
                    arr[j] = 1;
                }
        }

        for(int i=m;i<=n;i++) {
            if(arr[i] == 0) {
                sum += i;
                idx = Math.min(i,idx);
            }
        }
        if(sum == 0) lst.add(-1);
        else {
            lst.add(sum);
            lst.add(idx);
        }
        return lst;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();

        for(int x : T.solution(m,n)) {
            System.out.println(x);
        }
    }
}