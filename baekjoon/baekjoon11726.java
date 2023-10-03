package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon11726 {
	public static final int mod = 10007;

	public static void main(String[] args) throws Exception {
		// 2xn 타일링
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long result = 0;
		long[] dp = new long[N + 1];

		if (N == 1) {
			result = 1;
		} else if (N == 2) {
			result = 2;
		} else if (N > 2) {
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
			}

			result = dp[N];
		}

		System.out.println(result);
	}

}
