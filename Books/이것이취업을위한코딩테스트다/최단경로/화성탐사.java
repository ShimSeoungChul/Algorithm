import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.06 x

입력예시
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */
public class 화성탐사 {
	private static class Node implements Comparable<Node> {
		private final int x;
		private final int y;
		private final int distance;

		private Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		private int getX() {
			return x;
		}

		private int getY() {
			return y;
		}

		private int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node other) {
			return this.getDistance() - other.getDistance();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testNum = sc.nextInt(); // 테스트 케이스 수

		for (int i = 0; i < testNum; i++) {
			findShortestPath(sc);
		}
	}

	private static void findShortestPath(Scanner sc) {
		int N = sc.nextInt(); // 탐사 공간의 크기, 2 <= N <= 125
		int[][] distance = new int[N][N]; // 최단 경로 테이블
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		int[] dx = {0, 1, -1, 0};
		int[] dy = {1, 0, 0, -1};

		// 각 칸의 비용 입력
		int[][] graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		// 시작 위치는 (0, 0)
		int x = 0;
		int y = 0;
		// 우선순위큐 초기화
		var pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0, graph[x][y]));
		distance[x][y] = graph[x][y];

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			x = node.getX();
			y = node.getY();
			int d = node.getDistance();

			// 꺼낸 노드를 이미 처리한 적 있다면 무시
			if (distance[x][y] < d) {
				continue;
			}

			// 현재 노드와 연결된 다른 인접 노드 확인
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 맵의 범위를 벗어나느 경우 무시
				if ( nx < 0 || nx >= N || ny < 0 || ny >= N){
					continue;
				}
				int cost = d + graph[nx][ny];
				// 현재 노드를 거쳐서, 다른 노드로 이동하는 거리다 더 짧은 경우
				if (cost < distance[nx][ny]){
					distance[nx][ny] = cost;
					pq.offer(new Node(nx, ny, cost));
				}
			}
		}

		System.out.println(distance[N-1][N-1]);
	}
}
