package algorithm.String;

import java.util.Scanner;

public class part1_1 {
	// 문자 찾기
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String ch = in.next(); // or char ch = in.next().charAt(0);

		int result = solution(str, ch);
		System.out.print(result);
	}

	private static int solution(String str, String ch) { // or char ch
		str = str.toLowerCase();
		ch = ch.toLowerCase(); // or ch = Character.toUpperCase(ch);
		String[] strArr = str.split("");
		int cnt = 0;
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals(ch) == true) { // or str.charAt(i) == ch
				cnt++;
			}
		}
		return cnt;
	}
}
