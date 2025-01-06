package 인강.딩코딩코.트리와힙_BFS와DFS_그리고DP;

// https://www.acmicpc.net/problem/14503
public class 샤오미로봇청소기TODO {
    public static int getCountOfDepartmentsCleanedByRobotVacuum(int r, int c, int d, int[][] roomMap) {
        int[] dx = new int [] {-1, 0, 1, 0};    // 북, 동, 남, 서
        int[] dy = new int [] {0, 1, 0, -1};

        int N = roomMap.length; // 행의 길이
        int M = roomMap[0].length;  // 열의 길이

        boolean[][] visited = new boolean[N][M];
        boolean continued = true;

        while (continued) {
            // 현재 칸이 아직 청소되지 않았으면 청소
            visited[r][c] = true;

            // 4칸 중 청소되지 않은 빈칸 있는지 확인
            boolean hasNotVisitedBlank = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 반시계 방향으로 돌면서 탐색하고, 빈 칸이 있다면 이동
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && roomMap[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    hasNotVisitedBlank = true;
                    break;
                }
            }

            // 4칸 중 청소되지 않은 빈칸이 없다면
            if (!hasNotVisitedBlank) {
                // 한 칸 후진할 수 있는지 확인하고
                int nx = r - dx[d];
                int ny = r - dy[d];

                // 후진한다.
                if (0 <= nx && nx < N && 0 <= ny && ny < M && roomMap[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                } else { // 후진이 불가능하면 동작을 멈춘다.
                    continued = false;
                }
            }
        }

        // visited에서 true 개수 == 청소 구역
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (visited[i][j]) count++;

        return count;
    }

    // 반복문으로 1~3 로직을 반복한다. 청소시 청소한 구역을 visited 처리한다. 청소기가 멈추면 반복문을 멈추고 break한다.

    public static void main(String[] args) {
//        int currentR = 7, currentC = 4, currentD = 0;
//        int[][] currentRoomMap = {
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
//                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//        };
//
//        System.out.println(getCountOfDepartmentsCleanedByRobotVacuum(currentR, currentC, currentD, currentRoomMap));

//        int[][] currentRoomMap2 = {
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
//                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
//                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//        };
//        System.out.println("정답 = 29 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(6, 3, 1, currentRoomMap2));

        int[][] currentRoomMap3 = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        System.out.println("정답 = 33 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(7, 4, 1, currentRoomMap3));

//        int[][] currentRoomMap4 = {
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//                {1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
//                {1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
//                {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 1, 0, 0, 1, 1, 0, 1},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//        };
//        System.out.println("정답 = 25 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(6, 2, 0, currentRoomMap4));

//        int[][] currentRoomMap5 = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1},
//        };
//        System.out.println("정답 = 1 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(1, 1, 0, currentRoomMap5));

        int[][] currentRoomMap6 = {
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 0},
        };
        System.out.println("정답 = 4 / 현재 풀이 값 = " + getCountOfDepartmentsCleanedByRobotVacuum(1, 1, 0, currentRoomMap6));

    }
}
