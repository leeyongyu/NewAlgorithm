package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_5 {
	static int[] coins;
	static int N;
	static int coin;
	static int cnt;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 동전교환
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		coins = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			coins[idx++] = Integer.parseInt(st.nextToken());
		}

		coin = Integer.parseInt(br.readLine());

		dfs(0, 0);
		System.out.println(result);
	}

	public static void dfs(int L, int sum) {
		if (sum > coin || L >= result) {
			return;
		}
		if (L == N) {
			if (sum == coin) {
				result = Math.min(result, cnt);
			}
		} else {
			for (int i = N - 1; i >= 0; i--) {
				cnt++;
				dfs(L + 1, sum + coins[i]);
				cnt--;
				dfs(L + 1, sum);
			}
		}
	}

}
