package algorithm.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class part9_4 {
	public static int N;

	public static void main(String[] args) throws Exception {
		// 최대 수입 스케쥴(PriorityQueue 응용)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Income> list = new ArrayList<>();
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		N = Integer.parseInt(br.readLine());
		int max = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int money = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			list.add(new Income(money, time));
		}

		Collections.sort(list);

		max = list.get(0).time;
		int j = 0;

		for (int i = max; i >= 1; i--) {
			for (; j < N; j++) {
				if (list.get(j).time < i)
					break;
				pQ.offer(list.get(j).money);
			}
			if (!pQ.isEmpty()) {
				answer += pQ.poll();
			}
		}

		System.out.println(answer);

	}

	public static class Income implements Comparable<Income> {
		int money;
		int time;

		Income(int m, int t) {
			this.money = m;
			this.time = t;
		}

		@Override
		public int compareTo(Income i) {
			return i.time - this.time;
		}
	}

}
