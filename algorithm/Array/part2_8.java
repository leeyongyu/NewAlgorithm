package algorithm.Array;

import java.util.Scanner;

public class part2_8 {

	public static void main(String[] args) {
		// 등수구하기
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = input.nextInt();
		}
		int[] answer = solution(array);

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static int[] solution(int[] array) {
		int[] rank = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			rank[i] = 1;
			for (int j = 0; j < array.length; j++) {
				if (array[i] < array[j]) {
					rank[i]++;
				}
			}
		}
		return rank;
	}
}
