package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2839 {

	public static void main(String[] args) throws IOException {
		// 설탕 배달
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int totalCnt = 0;
		while (true) {
			if (N % 5 == 0) {
				totalCnt += N / 5;
				System.out.println(totalCnt);
				break;
			} else {
				N -= 3;
				totalCnt++;
			}

			if (N < 0) {
				totalCnt = -1;
				System.out.println(totalCnt);
				break;
			}
		}
	}

}
