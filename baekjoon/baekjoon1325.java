package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon1325 {
	static int max = 0;
	static int count;
	static int[] dis;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// 효율적인 해킹(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 최대 노드 번호
		int M = Integer.parseInt(st.nextToken()); // 연결 고리 수

		dis = new int[N + 1];
		count = 0;
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(b).add(a);
		}

		for (int i = 1; i <= N; i++) {
			count = 0;
			visited = new boolean[N + 1];
			visited[i] = true;
			count++;
			dfs(i);
			if (max < count) {
				max = count;
			}
			dis[i] = count;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (max == dis[i]) {
				list.add(i);
			}
		}
		Collections.sort(list, Comparator.naturalOrder());

		for (Integer n : list) {
			System.out.print(n + " ");
		}
	}

	private static void dfs(int num) {
		for (Integer next : graph.get(num)) {
			if (visited[next] == false) {
				visited[next] = true;
				count++;
				dfs(next);
			}
		}

	}

}
