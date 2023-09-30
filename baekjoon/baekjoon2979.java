package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2979 {

	public static void main(String[] args) throws IOException {
		// 트럭 주차
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int totalCar = 0;
		int price = 0;
		int startTime = 0;
		int endTime = 0;
		List<Time> list = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new Time(s, "S"));
			list.add(new Time(e, "E"));
		}
		Collections.sort(list);

		if ("S".equals(list.get(0).state)) {
			totalCar += 1;
		}
		for (int i = 1; i < list.size(); i++) {
			int time = list.get(i).s - list.get(i - 1).s;
			if (totalCar == 1) {
				price += (totalCar * a * time);
			} else if (totalCar == 2) {
				price += (totalCar * b * time);
			} else if (totalCar == 3) {
				price += (totalCar * c * time);
			}
			if ("S".equals(list.get(i).state)) {
				totalCar += 1;
			} else if ("E".equals(list.get(i).state)) {
				totalCar -= 1;
			}
		}

		System.out.println(price);
	}

	public static class Time implements Comparable<Time> {
		public int s;
		public String state;

		public Time(int s, String e) {
			this.s = s;
			this.state = e;
		}

		@Override
		public int compareTo(Time t) {
			return this.s - t.s;
		}
	}

}
