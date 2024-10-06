import java.util.*;

class Main {

    public long solution(String n, int b) {

        long result = 0;
        int idx = 0; // 승 0,1,2,3 ...
        int num = 0; //각 자리의 숫자를 10진수로 바꿔줌

        for(int i=n.length()-1;i>=-0;i--) {
            char ch = n.charAt(i);
            if(ch>='0' && ch<='9')
                num = ch - '0';
            else
                num = ch - 55;
            result += num * Math.pow(b,idx++);
        }
        return result;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String n = kb.next();
        int b = kb.nextInt();

        System.out.print(T.solution(n,b));
    }

}