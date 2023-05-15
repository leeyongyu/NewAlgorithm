package algorithm.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class part10_4 {
	static int[] dy;

	public static void main(String[] args) throws IOException {
		// 가장 높은 탑 쌓기(LIS 응용)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		List<Brick> list = new ArrayList<>();
		dy = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.add(new Brick(size, height, weight));
		}

		int result = solution(list);
		System.out.println(result);
	}

	public static int solution(List<Brick> arr) {
		int answer = 0;

		Collections.sort(arr);
		dy[0] = arr.get(0).h;
		answer = dy[0];
		for (int i = 1; i < arr.size(); i++) {
			int maxH = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr.get(j).w > arr.get(i).w && dy[j] > maxH) {
					maxH = dy[j];
				}
			}
			dy[i] = maxH + arr.get(i).h;
			answer = Math.max(answer, dy[i]);
		}

		return answer;
	}

	public static class Brick implements Comparable<Brick> {
		public int s;
		public int h;
		public int w;

		Brick(int size, int height, int weight) {
			this.s = size;
			this.h = height;
			this.w = weight;
		}

		@Override
		public int compareTo(Brick o) {
			return o.s - this.s;
		}
	}

}
