package algorithm.DFS_BFS_Tree;

import java.util.Scanner;

public class part7_4 {
	static int[] fibo;

	public static void main(String[] args) {
		// 피보나치 수열(메모리제이션)
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		fibo = new int[N + 1];
		dfs(N);
		for (int i = 1; i <= N; i++) {
			System.out.print(fibo[i] + " ");
		}
	}

	private static int dfs(int n) {

		if (n == 1 || n == 2) {
			return fibo[n] = 1;
		}
		if (fibo[n] > 0) {
			return fibo[n];
		}

		return fibo[n] = dfs(n - 2) + dfs(n - 1);
	}
}
