package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1260 {
	static List<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트 그래프
	static boolean[] visited; // 방문 여부 배열
	static List<Integer> bfslist = new ArrayList<>(); // bfs 노드를 저장할 리스트
	static List<Integer> dfslist = new ArrayList<>(); // dfs 노드를 저장할 리스트

	public static void main(String[] args) throws IOException {
		// DFS와 BFS
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 그래프 세팅
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 그래프 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		bfs(V);

		visited = new boolean[N + 1];

		dfs(V);

		for (int i = 0; i < bfslist.size(); i++) {
			System.out.print(dfslist.get(i) + " ");
		}
		System.out.println();

		for (int i = 0; i < bfslist.size(); i++) {
			System.out.print(bfslist.get(i) + " ");
		}
	}

	private static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(num);
		visited[num] = true;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			bfslist.add(cur);

			for (Integer next : graph.get(cur)) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
	}

	private static void dfs(int num) {
		visited[num] = true;
		dfslist.add(num);
		for (Integer next : graph.get(num)) {
			if (visited[next] == false) {
				dfs(next);
			}
		}
	}

}
