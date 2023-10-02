package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon9095 {

	public static void main(String[] args) throws Exception {
		// 1 2 3 더하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 1) {
				System.out.println(1);
				continue;
			} else if (num == 2) {
				System.out.println(2);
				continue;
			} else if (num == 3) {
				System.out.println(4);
				continue;
			}

			dp = new int[num + 1];

			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			for (int j = 4; j < dp.length; j++) {
				dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
			}

			System.out.println(dp[num]);
		}
	}

}
