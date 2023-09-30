package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_8 {
	static int[][] com;
	static int[] b; // ex)5 = 4C0 4C1 4C2 4C3 4C4
	static int[] p;
	static int N;
	static int F;
	static int[] ch;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		// 수열 추측하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		com = new int[N + 1][N + 1];
		b = new int[N];
		p = new int[N];
		ch = new int[N + 1];

		for (int i = 0; i < N; i++) {
			b[i] = combi(N - 1, i);
		}
		dfs(0, 0);
	}

	public static int combi(int n, int r) {
		if (n == r || r == 0)
			return 1;
		if (com[n][r] != 0)
			return com[n][r];
		else
			return com[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
	}

	public static void dfs(int L, int sum) {
		if (flag)
			return;
		if (L == N) {
			if (F == sum) {
				for (int i = 0; i < N; i++) {
					System.out.print(p[i] + " ");
				}
				System.out.println();
				flag = true;
			}
		} else {
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;
					p[L] = i;
					dfs(L + 1, sum + (p[L] * b[L]));
					ch[i] = 0;
				}
			}
		}
	}

}
