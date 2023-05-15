package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon2309 {
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		// 일곱 난쟁이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr); // 오름차순 정렬

		int a = 0, b = 0;
		// 브루트포스 알고리즘
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum - arr[i] - arr[j]) == 100) {
					a = arr[i];
					b = arr[j];
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == a || arr[i] == b) {
				continue;
			}
			System.out.println(arr[i]);
		}
	}

}
