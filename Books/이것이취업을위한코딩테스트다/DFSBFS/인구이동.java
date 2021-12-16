
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
2021.12.16 x

입력예시1
2 20 50
50 30
20 40
출력예시1
1

입력예시2
2 40 50
50 40
20 40
출력예시2
0

입력예시3
2 20 50
50 30
30 40
출력예시3
1

입력예시4
3 5 10
10 15 20
20 30 25
40 22 10
출력예시4
2

입력예시5
4 10 50
10 100 20 90
80 100 60 70
70 20 30 40
50 20 100 10
출력예시5
3
 */

class Position{
	private int x;
	private int y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}
}

public class 인구이동 {
	static int N;
	static int L;
	static int R;
	static int totalCount = 0;
	static int[][] graph;
	static int[][] unions;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		graph = new int[N][N];
		unions = new int[N][N];

		// 인구 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				graph[r][c] = sc.nextInt();
			}
		}

		// 더 이상 인구 이동을 할 수 없을 때까지 반복
		while (true) {
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){
					unions[i][j] = -1;
				}
			}
			int index = 0;
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){
					if (unions[i][j] == -1){ // 해당 나라가 아직 처리되지 않았다면
						process(i, j, index);
						index += 1;
					}
				}
			}

			// 모든 인구 이동이 끝난 경우 반복문 종료
			// 모든 이동이 끝나면 process()에서 어떠한 unions의 변화도 없기 때문에 index 값이 그대로 N * N가 된다.
			if (index == N * N){
				break;
			} else {
				totalCount += 1;
			}
		}

		// 인구 이동 횟수 출력
		System.out.println(totalCount);
	}

	// 특정 위치에서 출발하여 모든 연합을 체크한 뒤 데이터 갱신
	public static void process(int x, int y, int index) {
		// (x, y)의 위치와 연결된 나라(연합 정보를 담는 리스트
		ArrayList<Position> united = new ArrayList<>();
		united.add(new Position(x,y));
		// 너비 우선 탐색 (BFS)를 위한 큐 라이브러리 사용
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x,y));
		unions[x][y] = index; // 현재 연합의 번호 할당
		int summary = graph[x][y]; // 현재 연합의 전체 인구 수
		int count = 1; // 현재 연합의 국가 수
		// 큐가 빌 때까지 반복(BFS)
		while (!q.isEmpty()){
			Position position = q.poll();
			x = position.getX();
			y = position.getY();
			// 현재 위치에서 4가지 방향을 확인하며
			for (int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 바로 앞에 있는 나라를 확인하며
				if (0 <= nx && nx < N && 0 <= ny && ny < N && unions[nx][ny] == -1) {
					// 앞에 있는 나라와 인구 차이가 L명 이상, R명 이하라면
					int gap = Math.abs(graph[nx][ny] - graph[x][y]);
					if (L <= gap & gap <= R){
						q.offer(new Position(nx, ny));
						// 연합에 추가하기
						unions[nx][ny] = index;
						summary += graph[nx][ny];
						count += 1;
						united.add(new Position(nx, ny));
					}
				}
			}
		}

		// 연합 국가까리 인구를 분배
		for (int i = 0; i < united.size(); i++){
			x = united.get(i).getX();
			y = united.get(i).getY();
			graph[x][y] = summary / count;
		}
	}
}