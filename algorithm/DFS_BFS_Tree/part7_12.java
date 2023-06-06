package algorithm.DFS_BFS_Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class part7_12 {

	static int[][] graph;
	static int[] visit;
	static int N;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// 경로탐색(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		String[] str = new String[M];

		for (int i = 0; i < M; i++) {
			str[i] = br.readLine();
		}
		bw.write(Integer.toString(solution(str, N)));
		bw.flush();
		bw.close();
	}

	private static int solution(String[] array, int N) {
		graph = new int[N + 1][N + 1];
		visit = new int[N + 1];
		for (int i = 0; i < array.length; i++) {
			String[] str = array[i].split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			graph[a][b] = 1;
		}
		visit[1] = 1;
		dfs(1);
		return cnt;
	}

	private static void dfs(int n) {
		if (n == N) {
			cnt++;
		} else {
			for (int i = 1; i < graph.length; i++) {
				if (graph[n][i] == 1 && visit[i] == 0) {
					visit[i] = 1;
					dfs(i);
					visit[i] = 0;
				}
			}

		}
	}
}
