package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon11508 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = input.nextInt();
		}

		Arrays.sort(num);

		int lt = num.length - 3, rt = num.length - 1;
		int sum = 0;
		while (rt >= 0) {
			if (lt >= 0) {
				sum += (num[lt + 1] + num[rt]);
				lt = lt - 3;
				rt = rt - 3;
			} else {
				if (lt == -1) {
					sum += (num[0] + num[1]);
				} else if (lt == -2) {
					sum += num[0];
				}
				rt = -1;
			}
		}
		System.out.print(sum);
	}

}
