package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class part6_5 {

	public static void main(String[] args) {
		// 중복 확인
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		char answer = solution(arr, N);
		System.out.print(answer);
	}

	private static char solution(int[] a, int N) {
		char result = 'U';

		Arrays.sort(a);
		for (int i = 0; i < N - 1; i++) {
			if (a[i] == a[i + 1]) {
				result = 'D';
				break;
			}
		}
		return result;
	}
}
