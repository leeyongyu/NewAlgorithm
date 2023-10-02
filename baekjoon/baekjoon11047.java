package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon11047 {

	public static void main(String[] args) throws Exception {
		// 동전 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		List<Integer> coins = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());

			coins.add(coin);
		}

		Collections.sort(coins, Comparator.reverseOrder());

		for (int i = 0; i < coins.size(); i++) {
			if (K % coins.get(i) == K) {
				continue;
			}
			if (K > 0) {
				count += K / coins.get(i);
				K = K % coins.get(i);
			} else {
				break;
			}
		}

		System.out.println(count);
	}

}
