package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1931 {

	public static void main(String[] args) throws IOException {
		// 회의실 배정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Time> list = new ArrayList<>();
		int totalCount = 1;
		int eTime = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			list.add(new Time(startTime, endTime));
		}
		Collections.sort(list);

		eTime = list.get(0).endTime;

		for (int i = 1; i < list.size(); i++) {
			Time t = list.get(i);
			if (t.startTime < eTime) {
				continue;
			}

			totalCount++;
			eTime = t.endTime;
		}

		System.out.println(totalCount);
	}

	public static class Time implements Comparable<Time> {
		int startTime;
		int endTime;

		Time(int s, int e) {
			this.startTime = s;
			this.endTime = e;
		}

		@Override
		public int compareTo(Time ot) {
			if (this.endTime == ot.endTime) {
				return this.startTime - ot.startTime;
			} else {
				return this.endTime - ot.endTime;
			}
		}
	}

}
