package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon12014 {

	public static void main(String[] args) throws Exception {
		// 주식 (최대증가수열)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr;
		int[] dp;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new int[N];
			dp = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				dp[j] = 1;
			}

			for (int k = 1; k < arr.length; k++) {
				for (int l = k - 1; l >= 0; l--) {
					if (arr[k] > arr[l]) {
						dp[k] = Math.max(dp[k], dp[l] + 1);
					}
				}
			}
			sb.append("Case #" + i + "\n");
			boolean isTrue = false;
			for (int k = 0; k < arr.length; k++) {
				if (K == dp[k]) {
					isTrue = true;
					break;
				}
			}
			if (isTrue) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb.toString());
	}

}
