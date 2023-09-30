package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_9 {
	static int[] pm;
	static int[] ch;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		// 조합 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pm = new int[M];
		ch = new int[N + 1];
		dfs(0, 1);
	}

	public static void dfs(int L, int num) {
		if (L == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(pm[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = num; i <= N; i++) {
				pm[L] = i;
				dfs(L + 1, i + 1);
			}
		}
	}

}
