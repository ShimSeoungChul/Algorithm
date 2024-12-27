package 프로그래머스.기출.pccp;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/340211
public class 충돌위험찾기TODO {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.solution(new int[][] {{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][] {{4, 2}, {1, 3}, {2, 4}}));
        System.out.println(solution.solution(new int[][] {{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][] {{4, 2}, {1, 3}, {4, 2}, {4, 3}}));
        System.out.println(solution.solution(new int[][] {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}}, new int[][] {{2, 3, 4, 5}, {1, 3, 4, 5}}));
    }
}


















class Point {
    int x;
    int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Solution2 {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, Point> pointMap  = new HashMap<>();
        List<List<Point>> routeList = new ArrayList<>();

        for (int i = 1; i <= points.length; i++) {
            pointMap.put(i, new Point(points[i-1][0], points[i-1][1]));
        }

        for (int[] route: routes) {
            int start = route[0];
            int end = route[1];

            Point startPoint = pointMap.get(start);
            Point endPoint = pointMap.get(end);

            int index = 0;
            Point currentPoint = new Point(startPoint.x, startPoint.y);
            while(!currentPoint.equals(endPoint)) {
                currentPoint = moveToEnd(currentPoint, endPoint);
                if (routeList.size() == index) routeList.add(new ArrayList<>());
                routeList.get(index).add(currentPoint);
                index++;
            }
        }

        int dangerousCount = 0;
        for (List<Point> pointList: routeList) {
            Set<Point> tmpSet = new HashSet<>();
            Set<Point> chechSet = new HashSet<>();
            for (Point point: pointList) {
                if (tmpSet.contains(point)) {
                    chechSet.add(point);
                } else {
                    tmpSet.add(point);
                }
            }
            dangerousCount += chechSet.size();
        }

        return dangerousCount;
    }

    public Point moveToEnd(Point startPoint, Point endPoint) {
        if (startPoint.equals(endPoint)) return new Point(startPoint.x, startPoint.y);

        if (startPoint.x != endPoint.x) {
            if (endPoint.x > startPoint.x) {
                startPoint.x += 1;
            } else  {
                startPoint.x -= 1;
            }
            return new Point(startPoint.x, startPoint.y);
        }

        if (startPoint.y != endPoint.y) {
            if (endPoint.y > startPoint.y) {
                startPoint.y += 1;
            } else  {
                startPoint.y -= 1;
            }
        }

        return new Point(startPoint.x, startPoint.y);
    }
}