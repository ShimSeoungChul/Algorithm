import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
입력 예시
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
 */
public class KruskalExam {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //노드의 개수와 간선(union 연산)의 개수 입력받기
        int v = sc.nextInt();
        int e = sc.nextInt();
        //부모 테이블 초기화
        int [] parent = new int[v+1];
        //모든 간선을 담을 리스트와 최종 비용을 담을 변수
        ArrayList<Edge> edges = new ArrayList<>();
        int result = 0;
        //부모 테이블상에서, 부모를 자기 자신으로 초기화
        IntStream.rangeClosed(1, v).forEach(i -> parent[i] = i);

        //모든 간선에 대한 정보 입력
        for(int i=0; i<e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost, a, b));
        }

        //간선을 비용순으로 정렬
        Collections.sort(edges);

        KruskalExam kruskal = new KruskalExam();
        //간선을 하나씩 확인하며
        for(int i=0; i<edges.size(); i++){
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            if(kruskal.findParent(parent,a) != kruskal.findParent(parent,b)){
                kruskal.unionParent(parent,a, b);
                result += cost;
            }
        }

        System.out.println("총 비용:"+result);
    }

    //특정 원소가 속한 집합 찾기
    private int findParent(int[] parent, int x){
        //루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (parent[x] != x)
            parent[x] = findParent(parent, parent[x]);
        return parent[x];
    }

    //두 원소가 속한 집합을 합치기
    private void unionParent(int []parent, int a, int b){
         a = findParent(parent, a);
         b = findParent(parent, b);
         if (a<b){
             parent[b] = a;
         }else{
             parent[a] = b;
         }
    }
}

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB){
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }
    public int getDistance(){
        return this.distance;
    }
    public int getNodeA(){
        return this.nodeA;
    }
    public int getNodeB(){
        return this.nodeB;
    }
    //거리(비용)이 짧을 수록 높은 우선순위
    @Override
    public int compareTo(Edge other){
        return this.distance - other.distance;
    }
}
