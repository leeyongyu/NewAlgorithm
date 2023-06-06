package algorithm.Array;

import java.util.Scanner;

public class part2_2 {

	public static void main(String[] args) {
		// 보이는 학생
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = input.nextInt();
		}
		System.out.print(solution(numArr, n));
	}

	private static int solution(int[] array, int n) {
		int result = 1;
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				result++;
			}
		}
		return result;
	}
}
