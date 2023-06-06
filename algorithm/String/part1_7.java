package algorithm.String;

import java.util.Scanner;

public class part1_7 {

	public static void main(String[] args) {
		// 회문문자열
		Scanner input = new Scanner(System.in);

		String str = input.next();

		System.out.print(solution(str));
	}

	private static String solution(String str) {
		String result = "";
		str = str.toLowerCase();
		if (isTrue(str)) {
			result = "YES";
		} else {
			result = "NO";
		}
		return result;
	}

	private static boolean isTrue(String str) {
		boolean isCircleStr = true;
		String reverse = new StringBuilder(str).reverse().toString();
		if (str.equals(reverse) == true) {
			isCircleStr = true;
		} else {
			isCircleStr = false;
		}
		return isCircleStr;
	}
}
