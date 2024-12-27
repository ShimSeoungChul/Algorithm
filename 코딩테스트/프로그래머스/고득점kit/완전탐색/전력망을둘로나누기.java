package 프로그래머스.고득점kit.완전탐색;

import java.util.*;

public class 전력망을둘로나누기 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        System.out.println(solution.solution(9, new int[][] {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(solution.solution(4, new int[][] {{1,2},{2,3},{3,4}}));
        System.out.println(solution.solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}

class Solution6 {
    Map<Integer, List<Integer>> linkMap;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        linkMap = new HashMap<>();

        for (int[] wire: wires) {
            if (linkMap.containsKey(wire[0])) {
                List<Integer> list = linkMap.get(wire[0]);
                list.add(wire[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(wire[1]);
                linkMap.put(wire[0], list);
            }

            if (linkMap.containsKey(wire[1])) {
                List<Integer> list = linkMap.get(wire[1]);
                list.add(wire[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(wire[0]);
                linkMap.put(wire[1], list);
            }
        }

        int minDiff = n;
        for (int[] wire: wires) {
            List<Integer> linked = linkMap.get(wire[0]);

            for (int i = 0; i < linked.size(); i ++) {
                if (linked.get(i) == wire[1]) {
                    linked.remove(i);
                    break;
                }
            }

            visited[wire[0]] = true;
            int towerCount = bfs(wire[0], 0) + 1;
            visited[wire[0]] = false;
            int towerCount2 = n - towerCount;

            minDiff = Math.min(Math.abs(towerCount - towerCount2), minDiff);

            linked.add(wire[1]);
        }

        return minDiff;
    }

    private int bfs(int tower, int linkedTowerNum) {
        List<Integer> linkedTowers = linkMap.get(tower);

        if (linkedTowers == null) {
            return linkedTowerNum;
        }

        for (int linkedTower: linkedTowers) {
            if (!visited[linkedTower]) {
                visited[linkedTower] = true;
                linkedTowerNum += 1;
                linkedTowerNum += bfs(linkedTower, 0);
                visited[linkedTower] = false;
            }
        }

        return linkedTowerNum;
    }
}