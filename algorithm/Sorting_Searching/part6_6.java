package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class part6_6 {

	public static void main(String[] args) {
		// 장난꾸러기
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		int[] answer = solution(arr);
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	private static int[] solution(int[] a) {
		int[] sorta = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			sorta[i] = a[i];
		}
		List<Integer> list = new ArrayList<>();
		Arrays.sort(sorta);
		for (int i = 0; i < a.length; i++) {
			if (a[i] != sorta[i]) {
				list.add(i + 1);
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
