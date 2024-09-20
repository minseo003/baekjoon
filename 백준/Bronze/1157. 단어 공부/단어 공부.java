import java.util.*;

class Main {

    public Character solution(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        str = str.toUpperCase();
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char key : map.keySet()) {
            if(map.get(key) == max) answer = '?';
            if(map.get(key) > max) {
                answer = key;
                max = map.get(key);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }
}