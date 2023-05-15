package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class part8_11 {
	static int[][] arr;
	static int[][] dis;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 미로 탐색(BFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		arr = new int[7][7];
		dis = new int[7][7];
		for (int i = 0; i < 7; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 7; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
			}
		}
		bfs(0, 0);
		if (dis[6][6] != 0) {
			System.out.println(dis[6][6]);
		} else {
			System.out.println("-1");
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();

		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
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
