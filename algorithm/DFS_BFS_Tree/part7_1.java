package algorithm.DFS_BFS_Tree;

import java.util.Scanner;

public class part7_1 {

	public static void main(String[] args) {
		// 재귀함수(스택프레임)
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		dfs(N);

	}

	private static void dfs(int n) {
		if (n == 0) {
			return;
		}
		// System.out.print(n+" "); -- 3 2 1 ...
		dfs(n - 1);
		System.out.print(n + " "); // 1 2 3 ...
	}
}
