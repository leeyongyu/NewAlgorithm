package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_6 {
	static int N;
	static int M;
	static int[] arr;
	static int[] pm;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		// 순열 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		pm = new int[M];
		visited = new int[N];
		int idx = 0;
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
	}

	public static void dfs(int L) {
		if (L == M) {
			for (int j = 0; j < M; j++) {
				System.out.print(pm[j] + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < N; i++) {
				if (visited[i] == 0) {
					visited[i] = 1;
					pm[L] = arr[i];
					dfs(L + 1);
					visited[i] = 0;
				}
			}
		}
	}

}
