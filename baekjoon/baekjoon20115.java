package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon20115 {

	public static void main(String[] args) throws Exception {
		// 에너지 드링크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int lt = 0;
		double sum = 0;

		List<Double> list = new ArrayList<>();

		String[] token = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			list.add(Double.parseDouble(token[i]));
		}

		Collections.sort(list);

		sum = list.get(list.size() - 1);

		while (lt < N - 1) {
			sum += list.get(lt) / 2;
			lt++;
		}

		System.out.println(sum);
	}

}
