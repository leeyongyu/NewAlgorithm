package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_7 {
	static int N;
	static int R;
	static int[][] combi;

	public static void main(String[] args) throws IOException {
		// 조합의 경우수(메모리제이션)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		combi = new int[N + 1][N + 1];
		int result = dfs(N, R);
		System.out.println(combi[N][R]);
	}

	public static int dfs(int n, int r) {
		if (n == r || r == 0) {
			return combi[n][r] = 1;
		}
		if (combi[n][r] != 0) {
			return combi[n][r];
		}

		return combi[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
	}

}
