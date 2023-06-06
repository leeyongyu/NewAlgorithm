package algorithm.String;

import java.util.Scanner;

public class part1_10 {

	public static void main(String[] args) {
		// 문자거리
		Scanner input = new Scanner(System.in);

		String str = input.next();
		char ch = input.next().charAt(0);

		solution(str, ch);
	}

	private static void solution(String str, char ch) {
		char[] charArr = str.toCharArray();
		int[] findIdx = new int[charArr.length];
		for (int i = 0; i < findIdx.length; i++) {
			findIdx[i] = findIdx.length;
		}
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ch) {
				for (int j = 0; j < findIdx.length; j++) {
					if (findIdx[j] > Math.abs(i - j)) {
						findIdx[j] = Math.abs(i - j);
					}
				}
			}
		}
		for (int i = 0; i < findIdx.length; i++) {
			System.out.print(findIdx[i] + " ");
		}
	}
}
