package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1904 {
	static final int MOD = 15746;

	public static void main(String[] args) throws IOException {
		// 01타일
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dp = new long[N + 1];

		if (N == 1) {
			System.out.println(1);
		} else if (N == 2) {
			System.out.println(2);
		} else if (N > 2) {

			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i < N + 1; i++) {
				dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
			}

			System.out.println(dp[N]);
		}
	}

}
