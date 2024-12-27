package 프로그래머스.기출.pccp;

import java.util.*;

public class 석유시추TODO {
    public static void main() {
        Solution3 solution = new Solution3();
        System.out.println(solution.solution(new int[][] {
                {0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}
        }));
    }
}

class Solution3 {
    boolean[][] visited;
    int[] oilByColumn;
    int[] dx = new int[] {0, 1, -1, 0};
    int[] dy = new int[] {1, 0, 0, -1};

    public int solution(int[][] land) {
        int y = land.length;
        int x = land[0].length;
        visited = new boolean[y][x];
        oilByColumn = new int[x];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                // 석유가 있고, 방문하지 않았다면
                if (land[j][i] == 1 && !visited[j][i]) {
                    bfs(i, j, land);
                }
            }
        }

        return Arrays.stream(oilByColumn).max().orElse(0);
    }

    public void bfs(int x, int y, int[][] land) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[y][x] = true;
        Set<Integer> visitedColumns = new HashSet<>();
        visitedColumns.add(x);
        int oilCount = 1;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (ny >= 0 && ny < land.length && nx >= 0 && nx < land[0].length && !visited[ny][nx] && land[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    visitedColumns.add(nx);
                    queue.add(new Point(nx, ny));
                    oilCount++;
                }
            }
        }

        for(int visitedColumn: visitedColumns) {
            oilByColumn[visitedColumn] += oilCount;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

