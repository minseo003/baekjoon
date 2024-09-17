import java.util.*;

class Main {

    public int solution(String str) {
        Stack<Character> stack = new Stack<>();
        char[] car = str.toCharArray();

        if(car.length == 1) return 1;

        for (int i = 0; i < car.length; i++) {
            if (i < car.length / 2) {
                stack.push(car[i]);
            } else {
                if (stack.peek().equals(car[i])) stack.pop();
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.print(T.solution(str));
    }
}