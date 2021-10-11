import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
class Node_ implements Comparable<Node_> {
    private int index;
    private int distance;

    Node_(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }
    public int getIndex() {
        return index;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지정록 설정
    @Override
    public int compareTo(Node_ o) {
       return o.distance - this.distance;
    }
}

public class EnhancedDijkstraExam {

    public static final int INF = Integer.MAX_VALUE; // 무한을 의미하는 값 설정
    // 노드의 개수(n), 간선의 개수(m), 시작 노드 번호(start)
    public static int n,m,start;
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node_>> graph = new ArrayList<>();
    // 최단 거리 테이블
    public static int[] d = new int[100001];

    private void dijkstra(int start){
        PriorityQueue<Node_> pq = new PriorityQueue<>();
        pq.offer(new Node_(start,0));
        d[start] = 0;
        while (!pq.isEmpty()){ // 큐가 비어있지 않다면
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node_ node_ = pq.poll();
            int dist = node_.getDistance(); //현재 노드까지의 비용
            int now = node_.getIndex(); //현재 노드
            //현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if(d[now]<dist) continue;;
            //현재 노드와 연결된 다른 인접한 노드들을 확인
            for(int i=0;i<graph.get(now).size(); i++){
                Node_ otherNode = graph.get(now).get(i);
                int cost = d[now] + otherNode.getDistance();
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost<d[otherNode.getIndex()]){
                    d[otherNode.getIndex()] = cost;
                    pq.offer(new Node_(otherNode.getIndex(),cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        IntStream.rangeClosed(0,n).forEach(i-> graph.add(new ArrayList<Node_>()));
        //모든 간선 정보 입력
        IntStream.range(0,m).forEach(i->{
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node_(b,c)); //a번 노드에서 b번 노드로 가는 비용이 c임
        });

        //최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d,INF);

        //다익스트라 알고리즘 수행
        EnhancedDijkstraExam dijkstraExam = new EnhancedDijkstraExam();
        dijkstraExam.dijkstra(start);

        //모든 노드로 가기 위한 최단 거리를 출력
        IntStream.rangeClosed(1,n).forEach(i->{
            if(d[i] == INF) System.out.println("INFINITY"); //도달할 수 없는 경우, 무한(INFINITY)라고 출력
            else System.out.println(d[i]);  //도달할 수  있는 경우 거리를 출력
        });
    }
}
