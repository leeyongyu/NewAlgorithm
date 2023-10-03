package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2468 {
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int N;

	public static void main(String[] args) throws Exception {
		// 안전 영역
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int maxH = 0;
		int result = 0;

		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int h = Integer.parseInt(st.nextToken());
				arr[i][j] = h;
				maxH = Math.max(maxH, h);
			}
		}
		for (int k = 0; k < maxH; k++) {
			visited = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == false && arr[i][j] > k) {
						visited[i][j] = true;
						count++;
						dfs(i, j, k);
					}
				}
			}
			result = Math.max(result, count);
		}

		System.out.println(result);
	}

	public static void dfs(int x, int y, int h) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == false && arr[nx][ny] > h) {

				visited[nx][ny] = true;
				dfs(nx, ny, h);
			}
		}
	}

}
