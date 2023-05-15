package baekjoon;

import java.util.Scanner;

public class baekjoon1929 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int M = input.nextInt();
		int N = input.nextInt();
		boolean[] flag = new boolean[N + 1];
		flag[0] = true;
		flag[1] = true;
		for (int i = 2; i <= N; i++) {
			if (flag[i]) {
				continue;
			}
			for (int j = 2 * i; j <= N; j += i) {
				flag[j] = true;
			}
		}
		for (int i = M; i <= N; i++) {
			if (flag[i] == false) {
				System.out.println(i);
			}
		}
	}

}
