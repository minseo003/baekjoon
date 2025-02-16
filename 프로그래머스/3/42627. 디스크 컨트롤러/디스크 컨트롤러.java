import java.util.*;

class Solution {
    public int solution(int[][] jobs) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int time = 0;
        int totalTime = 0;
        int count = 0;
        int jobIndex = 0;

        while(count < jobs.length) {

            while(jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (!pq.isEmpty()) {

                int[] job = pq.poll();
                time += job[1];
                totalTime += (time - job[0]);
                count++;
            } else {
                time = jobs[jobIndex][0];
            }
        }
        return totalTime / jobs.length;
    }
}