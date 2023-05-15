package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2583 {
	static int[][] arr;
	static int totalCnt;
	static boolean[][] visited;
	static int size = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		// 영역 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());// 행 개수
		N = Integer.parseInt(st.nextToken());// 열 개수
		int K = Integer.parseInt(st.nextToken());// 입력 줄

		arr = new int[M][N];
		visited = new boolean[M][N];

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			for (int x = ly; x < ry; x++) {
				for (int y = lx; y < rx; y++) {
					arr[x][y] = 1;
				}
			}
		}

		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (visited[x][y] == false && arr[x][y] == 0) {
					size = 1;
					visited[x][y] = true;
					totalCnt++;
					dfs(x, y);

					list.add(size);
				}
			}
		}

		Collections.sort(list);

		System.out.println(totalCnt);
		for (Integer n : list) {
			System.out.print(n + " ");
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && visited[nx][ny] == false && arr[nx][ny] == 0) {
				visited[nx][ny] = true;
				size++;
				dfs(nx, ny);
			}
		}
	}

}
