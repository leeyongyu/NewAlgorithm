package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon11399 {

	public static void main(String[] args) throws IOException {
		// ATM
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list, Comparator.naturalOrder());

		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j >= 0; j--) {
				sum += list.get(j);
			}
		}
		System.out.println(sum);
	}
}
