import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
2021.12.01 ▲

입력 예시
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
public class 숨바꼭질 {
	record Node(int index, int distance) implements Comparable<Node> {

		// 거리 기준으로 오름차순(우선순위)으로 정렬
		@Override
		public int compareTo(Node other) {
			return this.distance() - other.distance();
		}
	}

	public static void main(String[] args) {
		int INF = 1_000_000_000; // 무한대를 나타내는 충분히 큰 수
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 헛간의 수, 2 <= N <= 20,000
		int M = sc.nextInt(); // 양방향 통로의 수, 1 <= M <= 50,000

		var distance = new int[N + 1]; // 최단 경로 테이블
		Arrays.fill(distance,INF); // 최단 경로 테이블의 초기값을 모두 무한대로 설정

		// 헛간의 연결 관계를 나타내는 그래프 입력
		var graph = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = true;
		}

		// 시작 헛간 부터 각 헛간 까지의 최단 경로 찾기
		var pq = new PriorityQueue<Node>(); // 탐색할 헛간의 우선순위를 저장하는 큐
		int start = 1; // 출발 헛간
		distance[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentIndex = currentNode.index();
			int d = currentNode.distance();

			if (distance[currentIndex] < d) {
				continue;
			}

			for (int j = 1; j <= N; j++) {
				// 현재 노드와 연결된 노드만 확인
				if(graph[currentIndex][j] == false && graph[j][currentIndex] == false){
					continue;
				}

				if (distance[currentIndex] + 1 < distance[j]) {
					distance[j] = distance[currentIndex] + 1;
					pq.offer(new Node(j, distance[j]));
				}
			}
		}

		var result = new StringBuilder();
		int max = 0;
		int index = 0;
		for (int i = 1; i <= N; i++) {
			if (distance[i] != INF && max < distance[i] ) {
				index = i;
				max = distance[i];
			}

			if (i == N) {
				result.append(index).append(" ");
				result.append(max).append(" ");
			}
		}

		int count = 0;
		for (int d : distance){
			if (d == max){
				count++;
			}
		}

		result.append(count);
		System.out.println(result);
	}
}
