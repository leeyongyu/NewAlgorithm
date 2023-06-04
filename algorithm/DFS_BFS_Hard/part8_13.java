package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_13 {

	static boolean[][] visit;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		// 섬나라 아일랜드(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		visit = new boolean[N][N];
		arr = new int[N][N];
		int resultCnt = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false && arr[i][j] == 1) {
					visit[i][j] = true;
					dfs(i, j);
					resultCnt++;
				}
			}
		}
		System.out.println(resultCnt);

	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && visit[nx][ny] != true && arr[nx][ny] == 1) {
				visit[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
