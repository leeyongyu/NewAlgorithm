package algorithm.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class part10_1 {

	public static void main(String[] args) throws IOException {
		// 계단오르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];

		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}

		System.out.println(dp[N]);
	}

}
