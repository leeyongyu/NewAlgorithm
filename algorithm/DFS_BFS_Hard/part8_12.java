package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class part8_12 {
	static int[][] arr;
	static int[][] dis;
	static boolean[][] visited;
	static int N = 0, M = 0;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 토마토 BFS 활용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		dis = new int[N][M];
		visited = new boolean[N][M];

		int max = 0;

		boolean isAllone = true;
		boolean isZero = false;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());

				if (n == 0) {
					isAllone = false;
				} else if (n == -1) {
					visited[i][j] = true;
				}

				arr[i][j] = n;
			}
		}

		if (isAllone) {
			System.out.print("0");
		} else {
			bfs();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (dis[i][j] > max) {
						max = dis[i][j];
					}
					if (visited[i][j] == false && arr[i][j] == 0) {
						isZero = true;
					}
				}
			}

			if (isZero) {
				System.out.print("-1");
			} else {
				System.out.print(max);
			}
		}
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					queue.offer(new Point(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] == false && arr[nx][ny] == 0) {
					visited[nx][ny] = true;
					dis[nx][ny] = dis[cur.x][cur.y] + 1;
					queue.offer(new Point(nx, ny));
				}

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
