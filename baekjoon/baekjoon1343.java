package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon1343 {

	public static void main(String[] args) throws Exception {
		// 폴리오미노
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String result = "";

		String a = "AAAA";
		String b = "BB";

		str = str.replaceAll("XXXX", a);
		str = str.replaceAll("XX", b);

		result = str;

		if (str.contains("X")) {
			result = "-1";
		}

		System.out.println(result);

	}

}
