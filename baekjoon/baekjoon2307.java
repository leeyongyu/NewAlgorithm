package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2307 {
	static int[][] arr;
	static boolean[] visited;
	static int[] dis;
	static int N;
	static int M;
	static List<Point> list = new ArrayList<>();
	static List<Integer> afterlist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 도로검문
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 지점의 수
		M = Integer.parseInt(st.nextToken()); // 도로(간선)의 수

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		dis = new int[N + 1];
		int beforeNum = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()); // 도로 a
			int b = Integer.parseInt(st.nextToken()); // 도로 b
			int c = Integer.parseInt(st.nextToken()); // 가중치

			arr[a][b] = c;
			arr[b][a] = c;

			list.add(new Point(a, b, c));
		}

		bfs(1);

		beforeNum = dis[N];

		for (int i = 0; i < list.size(); i++) {
			visited = new boolean[N + 1];
			dis = new int[N + 1];
			Point p = list.get(i);

			int x = p.x;
			int y = p.y;
			int c = p.c;

			arr[x][y] = 0;
			arr[y][x] = 0;

			bfs(1);
			afterlist.add(dis[N] - beforeNum);

			arr[x][y] = c;
			arr[y][x] = c;
		}

		int time = 0;

		for (int i = 0; i < afterlist.size(); i++) {
			int afterNum = afterlist.get(i);
			if (afterNum == 0) {
				time = -1;
				break;
			} else {
				time = Math.max(time, afterlist.get(i));
			}
		}
		if (time != 0) {
			System.out.println(time);
		} else if (time == 0) {
			System.out.print("0");
		}
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		visited[num] = true;
		queue.offer(num);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (visited[i] == false && arr[cur][i] != 0) {
					visited[i] = true;

					dis[i] = dis[cur] + arr[cur][i];
					queue.offer(i);
				}
			}

		}
	}

	public static class Point {
		int x;
		int y;
		int c;

		Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
