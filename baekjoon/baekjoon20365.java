package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon20365 {

	public static void main(String[] args) throws Exception {
		// 블로그2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int blueCount = 0;
		int redCount = 0;
		int result = 0;

		for (int i = 1; i < str.length(); i++) {
			// 바뀌는 부분마다 count (더 많은 숫자가 원색으로 칠해짐)
			if (str.charAt(i) != str.charAt(i - 1)) {
				if ('B' == str.charAt(i - 1)) {
					blueCount++;
				} else if ('R' == str.charAt(i - 1)) {
					redCount++;
				}
			}

			// 배열 끝부분 count 처리
			if (i == str.length() - 1) {
				if ('B' == str.charAt(i)) {
					blueCount++;
				} else if ('R' == str.charAt(i)) {
					redCount++;
				}
			}
		}

		if (redCount > blueCount) {
			result = blueCount + 1;
		} else if (redCount < blueCount) {
			result = redCount + 1;
		} else {
			result = redCount + 1;
		}

		System.out.println(result);
	}

}
