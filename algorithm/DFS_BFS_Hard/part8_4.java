package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_4 {
	static int N;
	static int M;
	static int[] pm;

	public static void main(String[] args) throws IOException {
		// 중복순열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pm = new int[M];
		dfs(0);
	}

	public static void dfs(int L) {
		if (L == M) {
			for (int j = 0; j < M; j++) {
				System.out.print(pm[j] + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= N; i++) {
				pm[L] = i;
				dfs(L + 1);
			}
		}
	}

}
