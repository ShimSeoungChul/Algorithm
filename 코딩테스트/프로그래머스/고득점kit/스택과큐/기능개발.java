package 프로그래머스.고득점kit.스택과큐;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5}))); // [2, 1]
        System.out.println(Arrays.toString(solution.solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1}))); // [1, 3, 2]
    }
}


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Progress> progressList = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            progressList.offer(new Progress(progresses[i], speeds[i]));
        }

        while (!progressList.isEmpty()) {
            for (Progress progress: progressList) {
                progress.progress += progress.speed;
            }

            if (progressList.peek().progress >= 100) {
                int deleteCount = 0;
                for (Progress progress: progressList) {
                    if (progress.progress >= 100) {
                        deleteCount++;
                    } else {
                        break;
                    }
                }
                answer.add(deleteCount);

                for (int i = 0; i < deleteCount; i++) {
                    progressList.poll();
                }
            }

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Progress {
    int progress;
    int speed;

    public Progress(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

/*
1) 가장 앞의 progresse가 진도가 100 이상이 될 때까지 작업을 진행시킨다.
2) 가장 앞의 progresse가 진도가 100 이상이 되면, 현재 진도가 100 이상인 모든 작업을 제거하고 제거한 개수를 answer에 입력한다.
3) 모든 progresse가 제거될 때까지 해당 작업을 반복한다.
*/