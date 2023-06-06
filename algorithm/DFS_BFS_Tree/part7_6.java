package algorithm.DFS_BFS_Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class part7_6 {
	static int[] ch;
	static int N;

	public static void main(String[] args) throws IOException {
		// 부분집합 구하기(DFS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		ch = new int[N + 1];
		Dfs(1);
	}

	private static void Dfs(int n) {

		if (n == N + 1) {
			String tmp = "";
			for (int i = 1; i <= N; i++) {
				if (ch[i] == 1) {
					tmp += i + " ";
				}
			}
			if (tmp.length() > 0) {
				System.out.println(tmp);
			}
		} else {
			ch[n] = 1;
			Dfs(n + 1);
			ch[n] = 0;
			Dfs(n + 1);
		}
	}
}
