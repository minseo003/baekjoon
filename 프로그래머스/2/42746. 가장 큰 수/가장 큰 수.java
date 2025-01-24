import java.util.*;

class Solution {

    public String solution(int[] numbers) {

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arr.add(Integer.toString(numbers[i]));
        }
        Collections.sort(arr, (x, y) -> (y + x).compareTo(x + y));

        StringBuilder answer = new StringBuilder();
        for (String num : arr) {
            answer.append(num);
        }

        if (answer.toString().startsWith("0")) {
            return "0";
        }

        return answer.toString();
    }
}