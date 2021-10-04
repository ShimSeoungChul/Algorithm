public class DFS_재귀 {
    public static void main(String[] args){

        //각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
        int [][]graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};

        //각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
        boolean [] visited = {false, false, false ,false ,false ,false ,false ,false, false};

        //정의된 DFS 함수 호출
        DFS_재귀 dfsExam = new DFS_재귀();
        dfsExam.dfs(graph, 1, visited);
    }

    /*
     * dfs 메서드
     *  @param graph 노드 연결 정보를 저장
     *  @param v 방문을 시작하는 최상단 노드의 위치
     *  @param visited 노드 방문 정보를 저장
     */
    void dfs(int [][]graph,int v, boolean [] visited){
        //현재 노드를 방문 처리
        visited[v] = true;
        System.out.print(v + " ");

        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        for(int i : graph[v]){
            if(visited[i]==false)
                dfs(graph, i, visited);
        }
    }
}