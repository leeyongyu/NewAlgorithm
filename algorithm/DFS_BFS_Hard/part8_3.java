package algorithm.DFS_BFS_Hard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part8_3 {
	static int[] score;
	static int[] times;
	static int N;
	static int M;
	static int max = Integer.MIN_VALUE;
	static int sum = 0;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		// 최대점수 구하기(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 문제의 개수
		M = Integer.parseInt(st.nextToken()); // 제한 시간

		score = new int[N];
		times = new int[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			score[i] = Integer.parseInt(st.nextToken()); // 점수
			times[i] = Integer.parseInt(st.nextToken()); // 걸리는 시간
		}

		dfs(0, 0, 0);

		System.out.println(max);
	}

	private static void dfs(int sum, int time, int idx) {
		if (time > M) {
			return;
		}
		if (idx == N) {
			max = Math.max(max, sum);
		} else {
			dfs(sum + score[idx], time + times[idx], idx + 1);
			dfs(sum, time, idx + 1);
		}
	}
}
