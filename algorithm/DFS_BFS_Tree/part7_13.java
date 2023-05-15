package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class part7_13 {
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static int totalCnt = 0;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 경로 탐색(인접 리스트)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
		}
		visited[1] = true;
		dfs(1);

		bw.write(Integer.toString(totalCnt));
		bw.flush();
		bw.close();
	}

	private static void dfs(int n) {
		if (n == 5) {
			totalCnt++;
		} else {
			for (Integer num : graph.get(n)) {
				if (visited[num] != true) {
					visited[num] = true;
					dfs(num);
					visited[num] = false;
				}
			}
		}
	}

}
