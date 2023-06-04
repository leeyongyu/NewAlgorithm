package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon11501 {

	public static void main(String[] args) throws IOException {
		// 주식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long max = 0;
		long sum = 0;
		int N = Integer.parseInt(st.nextToken()); // 테스트케이스 수
		long[] arr;
		List<Long> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			sum = 0;
			int idx = 0;
			max = 0;
			int n = Integer.parseInt(br.readLine());
			arr = new long[n];
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}
			for (int j = n - 1; j >= 0; j--) {
				long curMoney = arr[j];
				if (curMoney > max) {
					max = curMoney;
				} else {
					sum += (max - curMoney);
				}
			}
			list.add(sum);
		}
		for (Long n : list) {
			System.out.println(n);
		}
	}

}
