import java.io.*;
import java.util.*;

class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
            int num = Integer.parseInt(st.nextToken());
            room(arr, num);
        }
    }

    static void room(int[][] arr, int num) {
        int row = arr.length;
        int floor;
        if(num % row == 0) {
        floor = row;
        }else {
            floor = num % row;
        }
        int number;
        if(num % row == 0) {
            number = num / row;
        }else {
            number = num / row + 1;
        }
        System.out.println(floor * 100 + number);
    }
}