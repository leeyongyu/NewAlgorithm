package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class baekjoon1758 {

	public static void main(String[] args) throws Exception {
		// 알바생 강호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		long sum = 0;

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
		}

		// 금액 내림차순 정렬
		Collections.sort(list, Comparator.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			int tipMoney = list.get(i);
			int rank = i + 1;
			int resultTip = fnCalc(tipMoney, rank);

			// 0보다 큰 경우만 계산
			if (resultTip > 0) {
				sum += resultTip;
			} else {
				// 0이거나 작을 경우 그 이후의 작은 금액 모두 스킵
				break;
			}
		}

		System.out.println(sum);
	}

	public static int fnCalc(int money, int rank) {
		return money - (rank - 1);
	}

}
