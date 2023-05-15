package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon4963 {

	static int totalCnt; // 섬의 개수
	static int[][] arr;
	static boolean[][] visited; // 배열을 방문했는지(섬이 연결되어 있는지) 확인 변수
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int w = 0, h = 0;

	public static void main(String[] args) throws IOException {
		// 섬의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st;
		// 마지막 입력이 "0 0"이 아닐동안 반복
		while ("0 0".equals(str) != true) {
			str = br.readLine(); // w h 입력
			// "0 0"일때 종료.
			if ("0 0".equals(str)) {
				break;
			}
			st = new StringTokenizer(str, " ");
			w = Integer.parseInt(st.nextToken()); // 길이
			h = Integer.parseInt(st.nextToken()); // 높이

			// static 변수 초기화
			arr = new int[h][w];
			visited = new boolean[h][w];
			totalCnt = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); // 배열 입력
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// dfs 조건문
					if (visited[i][j] == false && arr[i][j] == 1) {
						visited[i][j] = true;
						dfs(i, j);
						totalCnt++; // 모든방향 dfs 탐색 후 섬의 개수 증가
					}
				}
			}
			System.out.println(totalCnt);
		}
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			// 8방향 탐색, visit 여부 확인
			if (ax > -1 && ax < h && ay > -1 && ay < w && arr[ax][ay] == 1 && visited[ax][ay] == false) {
				visited[ax][ay] = true;
				dfs(ax, ay);
			}
		}
	}
}
