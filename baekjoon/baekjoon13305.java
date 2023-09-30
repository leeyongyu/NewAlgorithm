package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon13305 {

	public static void main(String[] args) throws IOException {
		// 주유소
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dis = new long[N];
		long[] oilPrice = new long[N];
		int minPoint = 0;
		long cost = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < dis.length; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < oilPrice.length; i++) {
			oilPrice[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N; i++) {
			cost += oilPrice[minPoint] * dis[i];
			if (oilPrice[minPoint] > oilPrice[i]) {
				minPoint = i;
			}
		}
		System.out.println(cost);

	}
}
