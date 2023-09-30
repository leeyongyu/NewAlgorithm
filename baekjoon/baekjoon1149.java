package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1149 {

	public static void main(String[] args) throws IOException {
		// RGB거리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int result = Integer.MAX_VALUE;
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		for (int i = 0; i < 3; i++) {
			result = Math.min(result, dp[N - 1][i]);
		}

		System.out.println(result);

	}

}
