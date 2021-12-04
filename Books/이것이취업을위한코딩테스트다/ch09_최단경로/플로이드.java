import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.04 ●

입력 예시
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */
public class 플로이드 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt(); // 도시의 개수
		final int m = sc.nextInt(); // 버스의 개수
		final int INF = 1_000_000_000; // 무한을 의미하는 충분히 큰 수

		// 도시간 연결 정보를 저장하는 그래프 초기화
		int[][] graph = new int[n+1][n+1];
		IntStream.rangeClosed(1,n).forEach(i->{
			Arrays.fill(graph[i],INF); // 모든 그래프 원소의 초기 값을 무한대로 설정
			graph[i][i] = 0; // 자신에서 자신까지는 거리를 0으로 초기화
		});

		// 도시간 연결 정보 입력
		IntStream.rangeClosed(1,m).forEach(i->{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int distance = sc.nextInt();
			graph[a][b] = distance;
		});

		// 최단 경로 탐색
		for(int a = 1; a <= n; a++)
			for(int b = 1; b <= n; b++)
				for (int k = 1; k <= n; k++){
					graph[a][b] = Integer.min(graph[a][b],graph[a][k] + graph[k][b]);
				}

		// 결과 출력
		for(int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (graph[a][b] >= INF) {
					System.out.print("0 ");
				} else {
					System.out.print(graph[a][b] + " ");
				}
			}
			System.out.println();
		}
	}
}