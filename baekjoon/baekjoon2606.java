package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2606 {
	static List<ArrayList<Integer>> graph = new ArrayList<>(); // 연결 노드 인접리스트
	static boolean[] visited; // 방문 여부 배열
	static int totalCnt; // 연결된 노드 개수

	public static void main(String[] args) throws IOException {
		// 바이러스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int M = Integer.parseInt(br.readLine()); // 연결 노드 수

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 그래프 노드 입력
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		bfs(1); // 1에 연결된 노드 찾기

		System.out.println(totalCnt);
	}

	private static void bfs(int pos) {
		Queue<Integer> queue = new LinkedList<>();
		visited[pos] = true;

		queue.offer(pos);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : graph.get(cur)) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.offer(next);
				}
			}
		}
		for (int i = 2; i < visited.length; i++) {
			if (visited[i]) { // 방문한것은 1에 연결된 노드
				totalCnt++;
			}
		}
	}

}
