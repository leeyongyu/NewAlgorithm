package baekjoon;

import java.util.Scanner;

public class baekjoon12933 {
	// 실패코드(예제입력만 돌아감)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		int cnt = 0;
		int result = 0;
		boolean[] visited = new boolean[str.length()];
		boolean oneDuck = false;
		if ((str.length() % 5 != 0) || str.charAt(0) != 'q') {
			result = -1;
		} else {
			for (int i = 0; i < 5; i++) {
				if (cnt == 0 && str.charAt(i) == 'q') {
					cnt = 1;
				} else if (cnt == 1 && str.charAt(i) == 'u') {
					cnt = 2;
				} else if (cnt == 2 && str.charAt(i) == 'a') {
					cnt = 3;
				} else if (cnt == 3 && str.charAt(i) == 'c') {
					cnt = 4;
				} else if (cnt == 4 && str.charAt(i) == 'k') {
					cnt = 5;
				}
			}
			if (cnt == 5) {
				oneDuck = true;
			}
			if (oneDuck) {
				for (int i = 0; i < str.length(); i += 5) {
					cnt = 0;
					if (str.charAt(i) == 'q')
						cnt++;
					if (str.charAt(i + 1) == 'u' && cnt == 1)
						cnt++;
					if (str.charAt(i + 2) == 'a' && cnt == 2)
						cnt++;
					if (str.charAt(i + 3) == 'c' && cnt == 3)
						cnt++;
					if (str.charAt(i + 4) == 'k' && cnt == 4)
						cnt++;

					if (cnt != 5) {
						result = -1;
						break;
					}
					result = 1;
				}
			} else {
				for (int i = 0; i < str.length(); i++) {
					cnt = 0;
					for (int j = i; j < str.length(); j++) {
						if (visited[j] == false && cnt == 0 && str.charAt(j) == 'q') {
							visited[j] = true;
							cnt = 1;
						} else if (cnt == 1 && str.charAt(j) == 'u' && visited[j] == false) {
							visited[j] = true;
							cnt = 2;
						} else if (cnt == 2 && str.charAt(j) == 'a' && visited[j] == false) {
							visited[j] = true;
							cnt = 3;
						} else if (cnt == 3 && str.charAt(j) == 'c' && visited[j] == false) {
							visited[j] = true;
							cnt = 4;
						} else if (cnt == 4 && str.charAt(j) == 'k' && visited[j] == false) {
							visited[j] = true;
							cnt = 5;
						} else if (cnt == 5 && str.charAt(j) == 'q' && visited[j] == false) {
							visited[j] = true;
							cnt = 1;
						}
					}
					if (cnt == 5) {
						result++;
					}

				}
			}
		}
		System.out.print(result);
	}

}
