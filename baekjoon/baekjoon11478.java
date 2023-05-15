package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class baekjoon11478 {

	public static void main(String[] args) throws IOException {
		// 서로 다른 부분 문자열의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				map.put(str.substring(i, j), map.getOrDefault(str.substring(i, j), 0) + 1);
			}
		}

		System.out.println(map.size());

	}
}
