import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
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
class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class DijkstraExam {
    static int[] distance;
    static int start;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int n; // 노드의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 노드 n, 간선 m 개수 입력
        n = sc.nextInt();
        int m = sc.nextInt();
        // 시작 노드 번호 입력
        start = sc.nextInt();
        // 방문 여부를 체크하는 배열
        visited = new boolean[n + 1];
        // 최단 거리 테이블을 모두 무한으로 초기화
        distance = IntStream.rangeClosed(0, n)
            .map(num -> Integer.MAX_VALUE)
            .toArray();

        // 모든 간선 정보를 저장하는 그래프 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        IntStream.range(0, m)
            .forEach(i -> {
                // a번 노드에서 b번 노드로 가는 비용은 c
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                graph.get(a).add(new Node(b, c));
            });

        // 다익스트라 알고리즘 수행
        dijkstra();

        // 모든 노드로 가기 위한 최단 거리 출력
        for(int i = 1; i <= n; i++){
            // 도달할 수 없는 경우, 무한(INFINITY)라고 출력
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INFINITY");
            }
            //
            else{
                System.out.println(distance[i]);
            }
        }
    }

    static void dijkstra() {
        // 시작 노드에 대해서 초기화
        distance[start] = 0;
        visited[start] = true;
        ArrayList<Node> startNode = graph.get(start);
        IntStream.range(0, startNode.size())
            .forEach(i -> distance[startNode.get(i).getIndex()] = startNode.get(i).getDistance());

        // 시작 노드를 제외한 전체 n-1 개의 노드에 대해 반복
        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드를 확인
            ArrayList<Node> nowNode = graph.get(now);
            for(int j = 0; j < nowNode.size(); j++){
                int cost = distance[now] + nowNode.get(j).getDistance();
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < distance[nowNode.get(j).getIndex()]){
                    distance[nowNode.get(j).getIndex()] = cost;
                }
            }
        }
    }

    static int getSmallestNode(){
        int minValue = Integer.MAX_VALUE;
        int index = 0; // 가장 최단 거리가 짧은 노드(인덱스)

        for(int i = 1; i <= n; i++){
            if(distance[i] < minValue && !visited[i]){
                minValue = distance[i];
                index = i;
            }
        }
        return index;
    }
}
