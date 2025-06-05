import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[8];
        String result = "";
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < arr.length - 1 ; i++) {
            if(arr[i + 1] == arr[i] + 1) {
                result = "ascending";
            }else if(arr[i + 1] == arr[i] - 1) {
                result = "descending";
            } else {
                result = "mixed";
                break;
            }
         }
         System.out.println(result);

    }
}