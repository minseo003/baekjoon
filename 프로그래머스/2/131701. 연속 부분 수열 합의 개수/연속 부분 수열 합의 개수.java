import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        // 부분 수열 길이를 1부터 n까지 반복
        for (int length = 1; length <= n; length++) {
            // 모든 시작점에 대해 탐색
            for (int start = 0; start < n; start++) {
                int sum = 0;
                // 현재 부분 수열의 길이만큼 합 구하기
                for (int i = 0; i < length; i++) {
                    int index = (start + i) % n;  //  원형 수열 처리
                    sum += elements[index];
                }
                sumSet.add(sum);  // 중복 제거된 합 저장
            }
        }

        return sumSet.size();  // 가능한 합 개수 반환
    }
}