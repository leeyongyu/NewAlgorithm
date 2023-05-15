package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon16916 {

	public static void main(String[] args) throws IOException {
		// 부분 문자열(kmp 알고리즘)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String token = br.readLine();

		int len = token.length();
		int count = 0;
		int lt = 0, rt = len;

		while (rt <= str.length()) {
			String sub = str.substring(lt, rt);
			if (sub.equals(token)) {
				count = 1;
				break;
			} else {
				lt++;
				rt++;
			}

		}

		System.out.print(count);
	}

}
