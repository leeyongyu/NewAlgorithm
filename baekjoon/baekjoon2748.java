package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon2748 {
	static long[] num = new long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long result = fibo(n);
		bw.write(Long.toString(result));
		bw.flush();
		bw.close();
	}

	private static long fibo(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else if (num[n] != 0) {
			return num[n];
		}
		return num[n] = fibo(n - 1) + fibo(n - 2);
	}
}
