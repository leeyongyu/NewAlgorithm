package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon8979 {

	public static void main(String[] args) throws IOException {
		// 올림픽
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int rate = 1;
		List<Nation> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			list.add(new Nation(no, gold, silver, bronze));
		}

		Collections.sort(list);

		list.get(0).rate = rate;

		for (int i = 1; i < list.size(); i++) {
			Nation cn = list.get(i);
			Nation pn = list.get(i - 1);
			if (cn.gold == pn.gold && cn.silver == pn.silver && cn.bronze == pn.bronze) {
				cn.rate = rate++;
			} else {
				cn.rate = ++rate;
			}
		}

		for (Nation n : list) {
			if (n.no == K) {
				System.out.println(n.rate);
			}
		}
	}

	public static class Nation implements Comparable<Nation> {
		public int no;
		public int gold;
		public int silver;
		public int bronze;
		public int rate;

		public Nation(int no, int g, int s, int b) {
			this.no = no;
			this.gold = g;
			this.silver = s;
			this.bronze = b;
		}

		@Override
		public int compareTo(Nation n) {
			if (this.gold == n.gold) {
				if (this.silver == n.silver) {
					return n.bronze - this.bronze;
				} else {
					return n.silver - this.silver;
				}
			} else {
				return n.gold - this.gold;
			}
		}
	}

}
