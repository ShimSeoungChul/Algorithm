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
public class DijkstraExam {
    public static void main(String[] arsgs){
        Scanner scanner = new Scanner(System.in);

        //노드의 개수, 간선의 개수 입력
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //시작 노드 번호 입력
        int start = scanner.nextInt();
        //각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
        int [][] graph = new int[n+1][n+1];
        //방문 여부를 체크하는 배열
        boolean[] visited = new boolean[n+1];
        //IntStream.range(0, visited.length).forEach(i->visited[i]=false);

        //최단 거리 테이블을 모두 무한으로 초기화
        int[] distance = new int[n+1];
        IntStream.range(0, distance.length).forEach(i->distance[i]=Integer.MAX_VALUE);

        //모든 간선 정보를 입력
        IntStream.range(0,m).forEach(i->{
                    //a번 노드에서 b번 노드로 가는 비용이 c임
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    int c = scanner.nextInt();
                    graph[a][b] = c;
                });
    }

    /* 방문하지 않은 노드 중 가장 최단 거리가 짧은 노드 번호 반환
     * @param n 노드 개수
     */
    public int getSmallestNode(int n){
        int minValue = Integer.MAX_VALUE;
        int index = 0; //가장 최단 거리가 짧은 노드(인덱스)
        IntStream.range(1, n+1).forEach(i->{

        });

        return index;
    }

    public void dijkstra(int start, int[][]graph, boolean[] visited, int[] distance){

    }
}
