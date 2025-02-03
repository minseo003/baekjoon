import java.util.*;

class Solution {

    static Map<String,Integer> map = new HashMap<>();

    public int solution(String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1],map.getOrDefault(clothes[i][1],0) + 1);
        }

        int answer = 1;
        for(int count : map.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}