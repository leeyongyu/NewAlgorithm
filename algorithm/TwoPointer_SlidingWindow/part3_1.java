package algorithm.TwoPointer_SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class part3_1 {

	public static void main(String[] args) {
		// 두 배열 합치기
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int[] arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = input.nextInt();
		}
		int M = input.nextInt();
		int[] arr2 = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = input.nextInt();
		}
		int[] answer = solution(N, arr1, M, arr2);

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static int[] solution(int N, int[] arr1, int M, int[] arr2) {
		int[] result = new int[N + M];
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(arr1[i]);
		}
		for (int i = 0; i < M; i++) {
			list.add(arr2[i]);
		}
		Collections.sort(list, Comparator.naturalOrder());

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
