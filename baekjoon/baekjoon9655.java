package baekjoon;

import java.util.Scanner;

public class baekjoon9655 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int curNum = 0;
		int count = 0;
		while (curNum != N) {
			int plus3 = N - (curNum + 3); // 현재숫자 +3
			int plus1 = N - (curNum + 1);// 현재숫자 +1
			if (plus3 <= 3 || plus1 == N) {
				curNum += 1;
			} else if (plus1 <= 3 || plus3 == N) {
				curNum += 3;
			} else if (plus3 > 3 && plus1 > 3) {
				curNum += 3;
			}
			count++;
		}
		if (count % 2 == 1) {
			System.out.print("SK");
		} else {
			System.out.print("CY");
		}
	}
}
