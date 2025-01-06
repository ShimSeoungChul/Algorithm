package 인강.딩코딩코.실전기출문제;

import java.util.*;

// https://fern-freeze-290.notion.site/5-57ada1b094714e5e80eeedeb25d255e9#8f37244d60fb48fda5a2543e530e5cf1
// LINE 인턴 채용 코딩테스트
public class 나잡아봐라TODO {
    public static void main(String[] args) {
        int c = 11;
        int b = 2;

        System.out.println(catchMe(c, b)); // 5가 나와야 합니다!

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
        System.out.println("정답 = 28 / 현재 풀이 값 = " + catchMe(550, 500));
    }

    public static int catchMe(int conyLoc, int brownLoc) {
        Queue<int[]> brownPostionQueue = new LinkedList<>(); // {위치, 시간} 저장하기
        brownPostionQueue.add(new int[]{brownLoc, 0});
        Map<Integer, Set<Integer>> visited = new HashMap<>(); // {위치: {시간1, 시간2, 시간3}} 저장하기
        for (int i = 0; i < 2000001; i++) {
            visited.put(i, new HashSet<>());
        }

        int time = 0;
        while(conyLoc <= 200000) {
            conyLoc = conyLoc + time;
            if (visited.get(conyLoc).contains(time)) {
                return time;
            }

            int queueSise = brownPostionQueue.size();
            for (int i = 0; i < queueSise; i++) {
                int[] brownPostion = brownPostionQueue.poll();
                int newTime = brownPostion[1] + 1;

                int newPosition = brownPostion[0] - 1;
                if (newPosition >= 0 && newPosition <= 200_000 && !visited.get(newPosition).contains(newTime)) {
                    brownPostionQueue.add(new int[] {newPosition, newTime});
                    visited.get(newPosition).add(newTime);
                }

                newPosition = brownPostion[0] + 1;
                if (newPosition >= 0 && newPosition <= 200_000 && !visited.get(newPosition).contains(newTime)) {
                    brownPostionQueue.add(new int[] {newPosition,newTime});
                    visited.get(newPosition).add(newTime);
                }

                newPosition = brownPostion[0] * 2;
                if (newPosition >= 0 && newPosition <= 200_000 && !visited.get(newPosition).contains(newTime)) {
                    brownPostionQueue.add(new int[] {newPosition,newTime});
                    visited.get(newPosition).add(newTime);
                }
            }

            time += 1;
        }

        // 실패
        return -1;
    }
}

// bfs를 통해 코니와 브라운의 시간별 모든 경우의 수를 계산하고, 게임이 끝나는 순간 게임을 종료한다.
