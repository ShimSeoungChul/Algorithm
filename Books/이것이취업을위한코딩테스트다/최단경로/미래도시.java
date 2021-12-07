import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.01 ▲

입력 예시 1
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

입력 예시 2
4 2
1 3
2 4
3 4
 */
public class 미래도시 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시 개수, 1 <= N <= 100
		int M = sc.nextInt(); // 경로 개수, 1 <= M <+ 100

		int INF = 1_000_000_000;  // 무한대를 나타내는 충분히 큰 수

		int[][] graph = new int[N+1][N+1]; // 연결된 회사의 최단 거리를 저장

		IntStream.rangeClosed(1,N).forEach(i -> {
			Arrays.fill(graph[i],INF); // 모든 경로를 무한으로 초기화
			graph[i][i] = 0; // 자신에서 자신으로 가는 거리는 0으로 초기화
		});

		// 연결된 회사 정보 입력
		IntStream.rangeClosed(1,M).forEach(i -> {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
		});

		int X = sc.nextInt();
		int K = sc.nextInt(); // 1 <= K <= 100

		// 모든 노드를 돌며, 최단 경로 입력
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= N; j++){
				for (int k = 1; k <= N; k++){
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		// 결과 출력
		int result = graph[1][K] + graph[K][X];

		if (result < INF){
			System.out.println(result);
		} else {
			System.out.println(-1);
		}

	}
}
