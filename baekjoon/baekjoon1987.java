package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon1987 {
	public static int X;
	public static int Y;
	public static char[][] arr;
	public static int max = 0;
	public static int answer = 1;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static boolean[][] visited;
	public static HashMap<Character, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		// 알파벳
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		arr = new char[X][Y];
		visited = new boolean[X][Y];

		for (int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < Y; j++) {
				arr[i][j] = str.charAt(j);
				map.put(str.charAt(j), 0);
			}
		}

		visited[0][0] = true;
		map.put(arr[0][0], 1);
		max = 1;

		dfs(0, 0);

		System.out.println(answer);

	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < X && ny >= 0 && ny < Y && visited[nx][ny] != true && map.get(arr[nx][ny]) == 0) {
				visited[nx][ny] = true;
				map.put(arr[nx][ny], 1);
				max = max + 1;
				answer = Math.max(answer, max);
				dfs(nx, ny);
				visited[nx][ny] = false;
				map.put(arr[nx][ny], 0);
				max = max - 1;
			}

		}
	}

}
