package 완전탐색;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N15652_N과M4_2 {
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] selected;

	private static void input() {
		N15652_N과M4.FastReader scan = new N15652_N과M4.FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		selected = new int[M + 1];
	}

	private static void rec_func(int k) {
		if (k == M + 1) { // 모두 고름
			// selected[1...M] 배열이 새롭게 탑색된 결과
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
		} else {
			// 1 ~ N 까지를 k 번 원소로 한 번씩 정하고,
			for (int cand = 1; cand <= N; cand++) {
				// 비 내림차순에 만족하지 않는 경우 제외
				if (k > 1 && selected[k-1] > cand) {
					continue;
				}

				// 사용 처리
				selected[k] = cand;

				// 매번 k+1 번부터 M번 원소로 재귀 호출
				rec_func(k + 1);

				// 사용 후 반납
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1);
		System.out.println(sb.toString());
	}

static class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public FastReader(String s) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(new File(s)));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
}
