import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> map = new HashMap<>();

        // 모든 전화번호를 HashMap에 저장
        for (String number : phone_book) {
            map.put(number, true);
        }

        // 모든 전화번호에 대해 접두사가 있는지 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
