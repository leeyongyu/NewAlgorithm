package algorithm.Greedy;

import java.util.Scanner;

public class part9_1 {

	public static void main(String[] args) {
		// 씨름선수
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		int[] height = new int[N];
		int[] weight = new int[N];

		for (int i = 0; i < N; i++) {
			height[i] = input.nextInt();
			weight[i] = input.nextInt();
		}

		System.out.print(solution(N, height, weight));
	}

	private static int solution(int n, int[] h, int[] w) {
		int result = 0;

		boolean[] flag = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (flag[i] == false) {
					if (h[i] < h[j] && w[i] < w[j]) {
						flag[i] = true;
						result++;
					}
				}
			}
		}

		return n - result;
	}
}
