package 정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/10825
public class N10825_국영수{
	static class Elem implements Comparable<Elem> {
	private String name;
	private int hangul;
	private int english;
	private int math;

	Elem(String name, int hangul, int english, int math) {
		this.name = name;
		this.hangul = hangul;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Elem o) {
		if (this.hangul != o.hangul) {
			return o.hangul - this.hangul;
		} else if (this.english != o.english) {
			return this.english - o.english;
		} else if (this.math != o.math) {
			return o.math - this.math;
		} else {
			return this.name.compareTo(o.name);
		}
	}
}

	static int N;
	static List<Elem> elemList = new ArrayList<>();

	public static void main(String[] args) {
		input();
		elemList.stream().sorted()
			.forEach(elem -> System.out.println(elem.name));
	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		IntStream.range(0, N).forEach(i->{
			String name = sc.next();
			int hangul = sc.nextInt();
			int english = sc.nextInt();
			int math = sc.nextInt();
			Elem elem = new Elem(name, hangul, english, math);
			elemList.add(elem);
		});
	}
}

