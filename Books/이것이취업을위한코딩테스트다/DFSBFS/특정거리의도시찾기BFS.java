
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
입력예시1
4 4 2 1
1 2
1 3
2 3
2 4
출력예시1
4

입력예시2
4 3 2 1
1 2
1 3
1 4
출력예시2
-1

입력예시3
4 4 1 1
1 2
1 3
2 3
2 4
출력예시3
2
3
 */
public class 특정거리의도시찾기BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시의 개수
		int M = sc.nextInt(); // 도로의 개수
		int K = sc.nextInt(); // 거리 정보
		int X = sc.nextInt(); // 출발 도시의 번호
		int INF = 1_000_000_000; // 무한대를 나타내는 충분히 큰 수

		var graph = new int[N + 1][N + 1];
		IntStream.rangeClosed(1, N).forEach(i -> Arrays.fill(graph[N], INF));

		IntStream.range(0, M).forEach(i -> {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		});

		var visited = new boolean[N+1];
		var distance = new int[N+1];

		Arrays.fill(distance, INF);

		Queue<Integer> queue = new LinkedList<>();
		int start = X;
		visited[start] = true;
		distance[start] = 0;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			// 인접하고, 방문한 적이 없는 노드 탐색
			for (int i = 1; i <= N; i++) {
				int num = graph[node][i];
				if (num == 1 && visited[i] == false){
					visited[i] = true;
					queue.offer(i);
					distance[i] = distance[node] + graph[node][i];
				}
			}
		}

		System.out.println();
		boolean hasK = false;
		int index = 0;
		for (int num : distance) {
			if (num == K) {
				System.out.println(index);
				hasK = true;
			}
			index ++;
		}

		if (!hasK) {
			System.out.println(-1);
		}
	}
}
