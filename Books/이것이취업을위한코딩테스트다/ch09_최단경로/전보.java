import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
2021.12.03 ▲

입력 예시
3 2 1
1 2 4
1 3 2
 */
public class 전보 {
	public static class Node implements Comparable<Node>{
		private int index;
		private int distance;
		public Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
		public int getIndex() {
			return index;
		}
		public int getDistance(){
			return distance;
		}

		@Override
		public int compareTo(Node other) {
			return this.getDistance() - other.getDistance();
		}
	}

	public static void main(String[] args){
		int INF = 1_000_000_000; // 무한을 나타내는 충분히 큰 수

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시 개수
		int M = sc.nextInt(); // 통로의 개수
		int C = sc.nextInt(); // 메세지를 보내고자 하는 도시

		// 최단 거리를 저장하는 테이블
		int[] distance = new int[N + 1];
		Arrays.fill(distance,INF); // 가장 큰 수로 초기화

		// 특정 도시 X(1차원배열)에서 다른 도시 Y(2차원배열)까지 메시지가 전달되는 시간 Z(배열 내에 저장되는 값) 입력
		var graph = new ArrayList<ArrayList<Node>>();
		IntStream.rangeClosed(0,N).forEach(i-> graph.add(new ArrayList<>()));

		IntStream.rangeClosed(1,M).forEach(i->{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Node(b,c));
		});

		// 연결된 노드 정보를 저장하는 우선순위 큐
		var pq = new PriorityQueue<Node>();
		// 시작 노드 초기화
		pq.offer(new Node(C,0));
		distance[C] = 0;

		// 최단 경로 탐색
		while(!pq.isEmpty()){ // 큐에 원소가 존재하지 않을 때까지 탐색
			// 큐 맨 위에 존재하는 거리가 가장 짧은 노드 선택
			Node node = pq.poll();
			int i = node.getIndex();
			int d = node.getDistance();

			// 꺼낸 노드를 이미 처리한 적이 있다면 무시
			if (distance[i] < d){
				continue;
			}

			// 현재 노드와 연결된 노드 확인
			ArrayList<Node> linkedNodes = graph.get(i);
			for(Node linkedNode : linkedNodes){
				// 현재 노드까지 거리와 연결된 노드의 거리를 합치고,
				int sum = d + linkedNode.getDistance();

				// 기존의 최단 거리와 비교하여 더 작다면 값을 갱신하고,
				// 더 짧은 경로를 찾은 노드 정보를 우선순위 큐에 삽입
				if (sum < distance[linkedNode.getIndex()]){
					distance[linkedNode.getIndex()] = sum;
					pq.offer(linkedNode);
				}
			}
		}

		int count = 0;
		int totalTime = 0;

		for(int i = 0; i < distance.length; i++){
			if(distance[i] != INF && distance[i] != 0){
				count ++;
				totalTime = Integer.max(totalTime, distance[i]);
			}
		}

		System.out.println(count + " " + totalTime);
	}
}
