package algorithm.Sorting_Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class part6_7 {

	public static void main(String[] args) throws IOException {
		// 좌표정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Point(x, y));
		}
		Collections.sort(list);

		for (Point p : list) {
			System.out.println(p.x + " " + p.y);
		}

	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x)
				return this.y - o.y;
			else
				return this.x - o.x;
		}
	}

}
