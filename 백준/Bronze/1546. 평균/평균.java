import java.util.*;

class Main {

    public double solution(int[] arr) {
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        double an = 0.0;
        double answer[] = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = (double) arr[i]/max*100;
        }

        for(double x : answer) {
            an += x;
        }
        return an/arr.length;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = kb.nextInt();
        }

        System.out.print(T.solution(arr));
    }
}