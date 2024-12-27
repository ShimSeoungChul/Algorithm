package 프로그래머스.기출.pccp;

// https://school.programmers.co.kr/learn/courses/30/lessons/340212

public class 퍼즐게임챌린지TODO {
    public static void main() {
        Solution4 solution = new Solution4();
        System.out.println(solution.solution(new int[] {1,5,3}, new int[] {2,4,7}, 30));
        System.out.println(solution.solution(new int[] {1, 4, 4, 2}, new int[] {6, 3, 8, 2}, 59));
        System.out.println(solution.solution(new int[] {1, 328, 467, 209, 54}, new int[] {2, 7, 1, 4, 3}, 1723));
        System.out.println(solution.solution(new int[] {1, 99999, 100000, 99995}, new int[] {9999, 9001, 9999, 9001}, 3456789012L));
    }
}














class Solution4 {
    public int solution(int[] diffs, int[] times, long limit) {
        int sizeOfPuzzle = diffs.length;

        int low = 1;
        int high = 100_000;

        while(low < high) {
            int mid = (high + low) / 2;

            if (possible(mid, sizeOfPuzzle, diffs, times, limit)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.printf("low:%d, high:%d:\n", low, high);

        return low;
    }

    public boolean possible(int level, int sizeOfPuzzle, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        boolean possible = false;
        for (int i = 0; i < sizeOfPuzzle; i++) {
            int time_cur = times[i];
            int time_prev = i == 0 ? 0 : times[i-1];
            int diff = diffs[i];

            if (diff <= level) {
                totalTime += time_cur;
            } else {
                totalTime += (long) (time_cur + time_prev) * (diff - level) + time_cur;
            }

            if (totalTime > limit)  break;
        }

        if (totalTime <= limit) possible = true;
        return possible;
    }
}
