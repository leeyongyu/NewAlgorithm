package algorithm.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part10_3 {
	/**
	 * 숫자가 이전 값보다 큰 경우, (현재 값)보다 (이전 값) +1이 크다면 변경
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 최대 부분 증가 수열(LIS)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dy = new int[N]; // 각 숫자마다 현재 최대 수열
		int max = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dy[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j > 0; j--) {
				// 현재 값 기준으로 앞에 값이 현재값 보다 작다면
				if (arr[i] > arr[j]) {
					// 숫자가 이전 값보다 큰 경우, (현재 값)보다 (이전 값) +1이 크다면 변경
					dy[i] = Math.max(dy[i], dy[j] + 1);
					max = Math.max(max, dy[i]);
				}
			}
		}
		System.out.println(max);

	}

}
