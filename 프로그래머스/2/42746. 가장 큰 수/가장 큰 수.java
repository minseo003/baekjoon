import java.util.*;

class Solution {

    public String solution(int[] numbers) {

        ArrayList<String> arr = new ArrayList<>();

        for (int x : numbers) {
            arr.add(Integer.toString(x));
        }

        Collections.sort(arr, (x, y) ->(y + x).compareTo(x + y));

        StringBuilder sb = new StringBuilder();

        if (arr.get(0).equals("0")) {
            return "0";
        }
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
        }
}