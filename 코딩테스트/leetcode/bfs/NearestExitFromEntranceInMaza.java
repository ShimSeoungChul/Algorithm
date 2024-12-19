package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/?envType=study-plan-v2&envId=leetcode-75
public class NearestExitFromEntranceInMaza {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int yLength = maze.length;
        int xLength = maze[0].length;

        boolean[][] visited = new boolean[yLength][xLength];

        Queue<Point> queue = new LinkedList<>();
        int startX = entrance[1]; // X 좌표
        int startY = entrance[0]; // Y 좌표

        queue.add(new Point(startX, startY, 0));
        visited[startY][startX] = true; // 올바르게 방문 처리

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i=0; i < 4; i++) {
                int nx = point.x() + dx[i];
                int ny = point.y() + dy[i];

                if (nx >= 0 && nx < xLength && ny >= 0 && ny < yLength){
                    if(!visited[ny][nx] && maze[ny][nx] == '.') {
                        int move = point.move() + 1;
                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny, move));
                    }
                } else {
                    if (point.move() >= 1) {
                        return point.move();
                    }
                }
            }
        }

        return -1;
    }
}

record Point(int x, int y, int move){}