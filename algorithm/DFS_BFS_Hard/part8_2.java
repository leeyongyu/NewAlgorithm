package algorithm.DFS_BFS_Hard;

import java.util.Scanner;

public class part8_2 {
	static int N, sum = 0, height = 0, max = 0;
	static int[] nums;

	public static void main(String[] args) {
		// 바둑이 승차(DFS)
		Scanner input = new Scanner(System.in);

		height = input.nextInt();
		N = input.nextInt();

		nums = new int[N];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		dfs(0, 0);

		System.out.print(max);
	}

	private static void dfs(int L, int sum) {
		if (N == L) {
			if (sum <= height) {
				max = Math.max(max, sum);
			}
		} else {
			dfs(L + 1, sum + nums[L]);
			dfs(L + 1, sum);
		}
	}
}
