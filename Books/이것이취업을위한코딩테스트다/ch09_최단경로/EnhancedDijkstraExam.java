import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
입력값
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */


public class EnhancedDijkstraExam {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int start;
    public static int[] distance;

    public static void main(String[] args) {
        // 노드의 개수 n, 간선의 개수 m, 시작 노드 start 입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        start = sc.nextInt();

        // 노드 간의 연결 관계를 그래프에 저장
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            // 노드 a와 b의 거리는 d
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            graph.get(a).add(new Node(b, d));
        }

        // 최단 거리를 저장하는 테이블 생성후 가장 큰 수로 초기화
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 다이직스트라 알고리즘 수행
        dijkstra();

        // 모든 노드로 가기 위한 최단 경로 출력
        for (int d : distance) {
            if (d == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d);
            }
        }
    }

    public static void dijkstra() {
        // 연결된 노드 정보를 저장하는 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드 초기화
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) { // 큐에 원소가 존재하면,
            // 큐 맨 위에 존재하는 거리가 가장 짧은 노드를 선택
            Node node = pq.poll();
            int i = node.getIndex();
            int d = node.getDistance();

            // 꺼낸 노드를 이미 처리한 적이 있다면 무시
            if (distance[i] < d) {
                continue;
            }

            // 현재 노드와 연결된 노드 확인
            ArrayList<Node> linkedNodes = graph.get(i);
            for (Node linkedNode : linkedNodes) {
                // 현재 노드까지의 거리와 연결된 노드의 거리를 합치고,
                int sum = d + linkedNode.getDistance();

                // 기존의 최단 거리와 비교하여, 더 작다면 값을 갱신한다.
                // 그리고 더 짧은 경로를 찾은 노드 정보들은 다시 우선순위 큐에 넣는다.
                if (sum < distance[linkedNode.getIndex()]) {
                    distance[linkedNode.getIndex()] = sum;
                    pq.offer(linkedNode);
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.getDistance() - other.getDistance();
        }
    }
}