import java.io.*;
import java.util.*;

class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);  // 2의 N제곱을 구하는 코드

        find(size,r,c); //재귀 시작
        System.out.println(count);

    }

    static void find(int size, int r, int c) {
        if(size == 1) return;  //배열크기가 1이면 더이상 나눌 수 없으니 탐색종료

        if(r < size/2 && c < size/2) { // 1사분면
            find(size/2,r,c);
        }else if(r < size/2 && c >= size/2) { // 2사분면
            count += size * size / 4;  // 전체크기의 1/4만큼 더하고 시작
            find(size/2,r,c-size/2);
        } else if(r >= size/2 && c < size/2) { // 3사분면
            count += (size * size / 4) * 2; // 전체크기의 2/4만큼 더하고 시작
            find(size/2, r - size/2,c);
        }else { // 4사분면
            count += (size * size / 4) * 3; // 전체크기의 3/4만큼 더하고 시작
            find(size/2, r - size/2, c - size/2);
        }
    }
}