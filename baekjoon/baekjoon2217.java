package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class baekjoon2217 {

	public static void main(String[] args) throws Exception {
		// 로프
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int max = 0;

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
		}

		Collections.sort(list, Comparator.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			max = Math.max(max, list.get(i) * count);
			count++;
		}

		System.out.println(max);

	}

}
