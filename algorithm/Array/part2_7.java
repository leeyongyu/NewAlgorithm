package algorithm.Array;

import java.util.Scanner;

public class part2_7 {

	public static void main(String[] args) {
		// 점수계산
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int[] numArr = new int[N];
		for (int i = 0; i < N; i++) {
			numArr[i] = input.nextInt();
		}

		int answer = solution(numArr);
		System.out.print(answer);

	}

	private static int solution(int[] array) {
		int[] score = new int[array.length];
		int result = 0;
		int idx = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 1) {
				idx++;
				score[i] = idx;
			} else {
				idx = 0;
			}
			result += score[i];
		}

		return result;
	}
}
