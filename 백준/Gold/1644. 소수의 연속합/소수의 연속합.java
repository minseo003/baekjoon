import java.util.*;
import java.io.*;


class Main {

    static int n;
    static boolean[] isPrime;
    static ArrayList<Integer> primes = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println(0);
            return;
        }

        sieve(n);
        System.out.println(window());
    }

    static void sieve(int x) {
        isPrime = new boolean[x+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= x; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= x; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= x; i++) {
            if(isPrime[i]) primes.add(i);
        }
    }

    static int window() {
        int left = 0, right = 0, sum = 0 , count = 0;

        while (true) {
            if (sum >= n) {
                sum -= primes.get(left++);
            } else if (right == primes.size()) {
                break;
            } else {
                sum += primes.get(right++);
            }
            if (sum == n) {
                count++;
            }
        }
        return count;
    }
}