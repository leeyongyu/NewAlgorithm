package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon14889 {
	public static int N;
	public static int[][] arr;
	public static int[] visited;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 스타트와 링크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			String[] strArr = br.readLine().split(" ");
			for (int j = 0; j < strArr.length; j++) {
				arr[i][j] = Integer.parseInt(strArr[j]);
			}
		}

		combi(0, 0);

		System.out.println(min);
	}

	public static void combi(int idx, int count) {
		if (count == N / 2) {
			int teamA = 0;
			int teamB = 0;
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited.length; j++) {
					if (i == j) {
						continue;
					}
					if (visited[i] == 1 && visited[j] == 1) {
						teamA += arr[i][j];
					} else if (visited[i] == 0 && visited[j] == 0) {
						teamB += arr[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(teamA - teamB));
		} else {
			for (int i = idx; i < N; i++) {
				if (visited[i] != 1) {
					visited[i] = 1;
					combi(i + 1, count + 1);
					visited[i] = 0;
				}
			}
		}
	}
}
