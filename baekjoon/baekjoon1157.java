package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baekjoon1157 {

	public static void main(String[] args) throws IOException {
		// 단어 공부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		int dupleCnt = 0;
		int maxLen = 0;
		char result = '?';

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		for (Character ch : map.keySet()) {
			if (map.get(ch) > maxLen) {
				maxLen = Math.max(maxLen, map.get(ch));
				result = ch;
			}
		}

		for (Character ch : map.keySet()) {
			if (maxLen == map.get(ch)) {
				dupleCnt++;
			}
		}
		if (dupleCnt > 1) {
			result = '?';
		}

		System.out.println(result);
	}

}
