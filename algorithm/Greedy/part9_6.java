package algorithm.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part9_6 {
	public static int[] uni;

	public static void main(String[] args) throws Exception {
		// 친구인가(Union&Find)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		uni = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			uni[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			Union(a, b);
		}

		st = new StringTokenizer(br.readLine());
		int ta = Integer.parseInt(st.nextToken());
		int tb = Integer.parseInt(st.nextToken());

		int ra = find(ta);
		int rb = find(tb);

		if (ra == rb)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	public static void Union(int a, int b) {
		int fa = find(a);
		int fb = find(b);

		if (fa != fb)
			uni[fa] = fb;
	}

	public static int find(int a) {
		if (a == uni[a])
			return a;
		else
			return uni[a] = find(uni[a]);
	}

}
