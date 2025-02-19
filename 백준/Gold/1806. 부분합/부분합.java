import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0, end = 0;
        int current_sum = 0;
        int min_length = n + 1;
        
        while (end < n) {
            // current_sum이 s 이상이 될 때까지 end를 증가시키며 더함
            while (current_sum < s && end < n) {
                current_sum += arr[end++];
            }
            
            // current_sum이 s 이상인 상태에서 start를 증가시키며 최소 길이 갱신
            while (current_sum >= s && start < n) {
                min_length = Math.min(min_length, end - start);
                current_sum -= arr[start++];
            }
        }
        
        if (min_length == n + 1) {
            System.out.println(0);
        } else {
            System.out.println(min_length);
        }
    }
}
