package 프로그래머스.고득점kit.완전탐색;

import java.util.*;

public class 피로도 {
    public static void main() {
        Solution5 solution = new Solution5();
        System.out.println(solution.solution(80, new int[][] {{80,20},{50,40},{30,10}}));   // 3
        System.out.println(solution.solution(80, new int[][] {{80,80},{50,40},{30,10}}));   // 2
        System.out.println(solution.solution(80, new int[][] {{80,80},{70, 70},{50,40},{30,10}})); // 2
    }
}

class Dungeon{
    int minPoint;
    int usingPoint;

    public Dungeon(int minPoint, int usingPoint) {
        this.minPoint = minPoint;
        this.usingPoint = usingPoint;
    }
}

class Solution5 {
    List<Dungeon>  dungeonList;
    Set<Integer> dungeonCountSet;
    boolean[] visited = new boolean[8];
    public int solution(int k, int[][] dungeons) {
        dungeonCountSet = new HashSet<>();
        dungeonList = new ArrayList<>();
        for (int[] dungeon: dungeons) {
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }

        dfs(k, 0, 0);

        return Collections.max(dungeonCountSet);
    }

    private void dfs(int currentPoint, int depth, int dungeonCount) {
        if (depth >= dungeonList.size()) {
            dungeonCountSet.add(dungeonCount);
            return;
        }

        for (int i = 0; i < dungeonList.size(); i++) {
            Dungeon dungeon = dungeonList.get(i);
            if (!visited[i]) {
                visited[i] = true;
                if (dungeon.minPoint <= currentPoint) {
                    dfs(currentPoint - dungeon.usingPoint, depth + 1, dungeonCount + 1);
                } else {
                    dfs(currentPoint, depth + 1, dungeonCount);
                }
                visited[i] = false;
            }
        }
    }
}