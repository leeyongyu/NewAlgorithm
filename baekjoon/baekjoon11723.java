package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon11723 {

	public static void main(String[] args) throws IOException {
		// 집합 (StringBuffer 사용해야 시간초과 안남)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int len = Integer.parseInt(br.readLine());
		List<Integer> allList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 20; i++) {
			allList.add(i);
		}

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			String job = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens()) {
				num = Integer.parseInt(st.nextToken());
			}

			if ("add".equals(job)) {
				if (list.contains(num) == false) {
					list.add(num);
				}
			} else if ("remove".equals(job)) {
				if (list.contains(num) == true) {
					list.remove(list.indexOf(num));
				}
			} else if ("check".equals(job)) {
				if (list.contains(num)) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
			} else if ("toggle".equals(job)) {
				if (list.contains(num)) {
					list.remove(list.indexOf(num));
				} else {
					list.add(num);
				}
			} else if ("all".equals(job)) {
				list = allList;
			} else if ("empty".equals(job)) {
				list = new ArrayList<>();
			}
		}

		System.out.println(sb.toString());

	}
}
