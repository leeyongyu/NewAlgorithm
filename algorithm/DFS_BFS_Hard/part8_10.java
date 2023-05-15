package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_10 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int totalCnt = 0;
	static int[][] carr;

	public static void main(String[] args) throws IOException {
		// 미로탐색(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[8][8];
		StringTokenizer st;
		for (int i = 1; i <= 7; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 7; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
			}
		}
		carr = arr;

		carr[1][1] = 1;
		dfs(1, 1);
		System.out.print(totalCnt);
	}

	private static void dfs(int x, int y) {
		if (x == 7 && y == 7) {
			totalCnt++;
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && carr[nx][ny] == 0) {
					carr[nx][ny] = 1;
					dfs(nx, ny);
					carr[nx][ny] = 0;
				}
			}
		}
	}

}
