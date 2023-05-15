package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon11403 {
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static int[][] arr;
	static boolean[] visited;
	static int sNum;
	static int fNum;
	static int N;

	public static void main(String[] args) throws IOException {
		// 경로 찾기(그래프 탐색)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					graph.get(i).add(j);
				}
			}
		}

		visited = new boolean[N + 1];

		dfs(1);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j] + " ");

			}
			System.out.println();
		}
	}

	private static void dfs(int n) {
		for (Integer next : graph.get(n)) {
			if (visited[next] == false) {
				visited[next] = true;
				arr[n][next] = 1;
				dfs(next);
			}
		}
	}

}
