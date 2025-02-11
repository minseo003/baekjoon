import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        int n = elements.length;

        // 모든 부분 수열 길이 탐색
        for (int length = 1; length <= n; length++) {
            int sum = 0;

            // 첫 번째 부분 수열의 합 구하기
            for (int i = 0; i < length; i++) {
                sum += elements[i];
            }
            sumSet.add(sum);

            // 슬라이딩 윈도우 방식으로 부분 수열 이동하며 합 갱신
            for (int start = 1; start < n; start++) {
                sum -= elements[start - 1]; // 윈도우 왼쪽 원소 제거
                sum += elements[(start + length - 1) % n]; // 오른쪽 원소 추가 (원형 처리)
                sumSet.add(sum);
            }
        }

        return sumSet.size();
    }
}
