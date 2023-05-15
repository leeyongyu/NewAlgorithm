package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1389 {
	static List<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트 생성
	static int[] dis; // 최단거리 배열
	static boolean[] visited; // 방문여부 배열
	static int min = Integer.MAX_VALUE; // 최소값 변수
	static int idx = 0; // 가장짧은 케빈 베이컨 숫자 저장 변수

	public static void main(String[] args) throws IOException {
		// 케빈 베이컨의 6단계 법칙
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 유저 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>()); // 인접리스트 초기화
		}
		// 인접리스트 쌍방향 세팅
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		// bfs 반복
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dis = new int[N + 1];
			bfs(i); // 1~N까지의 케빈 베이컨 계산
		}
		System.out.println(idx);
	}

	private static void bfs(int pos) {
		Queue<Integer> queue = new LinkedList<>();

		visited[pos] = true;
		dis[pos] = 0;
		int sum = 0;
		queue.offer(pos);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int next : graph.get(cur)) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.offer(next);
					dis[next] = dis[cur] + 1; // 최단거리 계산
				}
			}
		}
		for (int i = 1; i < dis.length; i++) {
			sum += dis[i];
		}
		if (min > sum) {
			min = sum;
			idx = pos;
		}
	}
}
