package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_1 {
	static int N;
	static int[] arr;
	static int[] used;
	static int sum = 0;
	static String answer = "NO";

	public static void main(String[] args) throws IOException {
		// 합이 같은 부분집합(DFS : 아마존 인터뷰)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		used = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);
		System.out.println(answer);
	}

	public static void dfs(int L, int sum) {
		if (L == N) {
			int sum2 = 0;
			for (int i = 0; i < L; i++) {
				if (used[i] == 0) {
					sum2 += arr[i];
				}
			}
			if (sum2 == sum) {
				answer = "YES";
			}
		} else {
			used[L] = 1;
			dfs(L + 1, sum + arr[L]);
			used[L] = 0;
			dfs(L + 1, sum);
		}
	}

}
