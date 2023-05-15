package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon12865 {

	static int[][] dp;
	static int[] W;
	static int[] V;

	public static void main(String[] args) throws IOException {
		// 평범한 배낭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		W = new int[N + 1]; // 무게
		V = new int[N + 1]; // 가치

		dp = new int[N + 1][K + 1];

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		// 냅색 알고리즘 Bottom-Up 방식
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {

				// i번째 무게를 더 담을 수 없는 경우
				if (W[i] > j) {
					dp[i][j] = dp[i - 1][j];
				}
				// i번째 무게를 더 담을 수 있는 경우
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}

}
