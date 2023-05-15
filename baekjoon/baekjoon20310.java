package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class baekjoon20310 {

	public static void main(String[] args) throws IOException {
		// 타노스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		Map<String, Integer> map = new HashMap<>();

		String[] token = str.split("");

		for (int i = 0; i < token.length; i++) {
			map.put(token[i], map.getOrDefault(token[i], 0) + 1);
		}
		int zeroCnt = map.get("0") / 2;
		int oneCnt = map.get("1") / 2;

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < zeroCnt; i++) {
			buffer.append("0");
		}
		for (int i = 0; i < oneCnt; i++) {
			buffer.append("1");
		}

		String result = buffer.toString();

		bw.write(result);
		bw.flush();
		bw.close();
	}
}
