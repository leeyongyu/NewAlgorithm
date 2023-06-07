package algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class part9_3 {

	public static void main(String[] args) throws IOException {
		// 결혼식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int max = 0;

		List<Time> list = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Time(x, 's'));
			list.add(new Time(y, 'e'));
		}
		Collections.sort(list);

		for (Time ob : list) {
			if (ob.state == 's') {
				cnt++;
			} else if (ob.state == 'e') {
				cnt--;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}

	public static class Time implements Comparable<Time> {
		int s;
		char state;

		public Time(int s, char state) {
			this.s = s;
			this.state = state;
		}

		@Override
		public int compareTo(Time o) {
			if (this.s == o.s)
				return this.state - o.state;
			else
				return this.s - o.s;
		}
	}

}
