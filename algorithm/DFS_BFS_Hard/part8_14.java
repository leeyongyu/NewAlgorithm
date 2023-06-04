package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class part8_14 {
	static int N; // 도시 배열 크기
	static int M; // 살리고자 하는 피자집 개수
	static List<Point> homeList = new ArrayList<>();
	static List<Point> pizzaList = new ArrayList<>();
	static int len = 0;
	static int[] combi;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS 활용)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					homeList.add(new Point(i, j));
				} else if (num == 2) {
					pizzaList.add(new Point(i, j));
				}
			}
		}

		len = pizzaList.size();
		combi = new int[M]; // 선택할 피자집의 콤비 개수 6C4
		dfs(0, 0);
		System.out.println(answer);
	}

	public static void dfs(int L, int s) {
		// 조합 L,s
		if (L == M) {
			int sum = 0;
			for (Point h : homeList) {
				int dis = Integer.MAX_VALUE;
				for (int i : combi) {
					dis = Math.min(dis, Math.abs(h.x - pizzaList.get(i).x) + Math.abs(h.y - pizzaList.get(i).y));
				}
				sum += dis;
			}
			answer = Math.min(answer, sum);
		} else {
			for (int i = s; i < len; i++) {
				combi[L] = i;
				dfs(L + 1, i + 1);
			}
		}
	}

	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
