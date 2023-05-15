package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baekjoon2667 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	static int areaCnt = 0;
	static int houseCnt = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		List<Integer> list = new ArrayList<>();
		int N = in.nextInt();
		String[] str = new String[N];
		in.nextLine();
		for (int i = 0; i < N; i++) {
			str[i] = in.nextLine();
		}
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			String row = str[i];
			for (int j = 0; j < map[i].length; j++) {
				char ch = row.charAt(j);
				if (ch == '1') {
					map[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				areaCnt = 0;
				if (map[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					areaCnt += 1;
					dfs(i, j, N);
					houseCnt += 1;
					list.add(areaCnt);
				}
			}
		}

		Collections.sort(list);
		System.out.println(houseCnt);
		for (Integer n : list) {
			System.out.println(n);
		}
	}

	private static void dfs(int x, int y, int N) {
		for (int i = 0; i < 4; i++) {
			int dx1 = x + dx[i];
			int dy1 = y + dy[i];

			if (dx1 >= 0 && dx1 < N && dy1 >= 0 && dy1 < N && map[dx1][dy1] == 1 && visited[dx1][dy1] == false) {
				areaCnt += 1;
				visited[dx1][dy1] = true;
				dfs(dx1, dy1, N);
			}
		}
	}

}
