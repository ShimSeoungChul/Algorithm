import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.05 x

입력 예시
6 6
1 5
3 4
4 2
4 6
5 2
5 4
 */
public class 정확한순위 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 2 <= N <= 500
		int M = sc.nextInt(); // 2 <= M <= 10000
		int INF = 1_000_000_000; // 무한대를 나타내는 충분히 큰 수

		int[][] graph = new int[N+1][N+1];
		IntStream.rangeClosed(1,N).forEach(i->{
			Arrays.fill(graph[i],INF); // 모든 경로를 무한대로 초기화
			graph[i][i] = 0; // 자신에서 자신의 경로는 0으로 초기화
		});

		// 성적을 비교한 결과가 있는 학생 관계는 1로 초기화
		IntStream.rangeClosed(1,M).forEach(i->{
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		});

		// 학생들 사이의 관계 최단 경로 구하기
		for (int i = 1; i <= N; i++){
			for ( int j = 1; j <= N; j++){
				for ( int k = 1; k <= N; k++){
					graph[i][j] = Integer.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		// 모든 노드에 대하여 다른 노드와 서로 도달 가능한지 체크한다. 자신은 항상 도달 가능하다고 가정하고, 카운트 한다.
		// 카운트 값이 N인 노드는 정확한 순위를 알 수 있다.
		int result = 0;
		for (int i = 1; i <= N; i++){
			int count = 0;
			for ( int j = 1; j <= N; j++){
				if (graph[i][j] != INF || graph[j][i] != INF) {
					count ++;
				}
			}

			if ( count == N ){
				result ++;
			}
		}

		System.out.println(result);
	}
}
