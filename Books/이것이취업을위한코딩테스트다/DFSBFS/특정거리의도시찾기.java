import java.util.Arrays;
import java.util.Scanner;

/*
2021.12.09

입력 예시1
4 4 2 1
1 2
1 3
2 3
2 4

출력 예시1
4

입력 예시2
4 3 2 1
1 2
1 3
1 4

출력 예시2
-1

입력 예시3
4 4 1 1
1 2
1 3
2 3
2 4

출력 예시3
2
3
 */
public class 특정거리의도시찾기 {

	static boolean[] visited;
	static int[] distance;
	static int[][] graph;
	static int N;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 도시의 개수, 2 <= N <= 300,000
		int M = sc.nextInt();	// 도로의 개수, 1 <= M <= 300,000
		int K = sc.nextInt();	// 거리 정보, 1 <= K <= 300,000
		int X = sc.nextInt();	// 출발 도시의 번호, 1 <= X <= N

		visited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE); // 모든 거리를 무한을 의미하는 충분히 큰 수로 초기화
		graph = new int[N+1][N+1];

		// 도시 연결 관계 입력
		for (int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}

		int start = X;
		distance[start] = 0;
		dfs(start);

		// 최단 거리가 K인 도시 출력
		boolean hasCity = false;
		for (int i = 1; i <= N; i ++){
			if (distance[i] == K){
				System.out.println(i);
				hasCity = true;
			}
		}

		if (!hasCity){
			System.out.println(-1);
		}

	}

	static void dfs(int v){
		// 방문 처리
		visited[v] = true;

		// 인접 노드 탐색
		for (int i = 1; i <= N; i++){
			if (graph[v][i] == 0){
				continue;
			}else{ // 인접 노드 중에 최단 거리 갱신이 가능한 노드는 갱신
				distance[i] = Integer.min(distance[i], distance[v] + 1);
			}

			// 방문하지 않은 인접 노드 중 가장 작은 것을 스택에 삽입
			if (!visited[i]){
				dfs(i);
			}
		}
	}
}
