package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15486 {
	public static int[] dp;

	public static void main(String[] args) throws Exception {
		// 퇴사 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int result = 0;

		dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			// 이전까지의 최댓값보다 현재까지의 최대값이 크다면 변경!
			if (max < dp[i]) {
				max = dp[i];
			}

			if (i + t < N + 2) {
				dp[i + t] = Math.max(dp[i + t], max + sc);
			}
		}
		for (int i = 1; i < dp.length; i++) {
			result = Math.max(result, dp[i]);
		}

		System.out.println(result);
	}

}
