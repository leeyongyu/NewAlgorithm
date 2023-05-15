package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1806 {
	static int[] arr;
	static int N;
	static int S;

	public static void main(String[] args) throws IOException {
		// 부분합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수열 개수
		S = Integer.parseInt(st.nextToken()); // 구하고자 하는 부분합

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = subTotal(); // 부분합 구하는 함수 호출

		System.out.println(result);
	}

	private static int subTotal() {
		int lt = 0, rt = 0; // 왼쪽 포인터 , 오른쪽 포인터 변수
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int pnum = 0; // 포인터간 거리 변수

		while (rt < arr.length) {
			if (sum >= S) {
				pnum = rt - lt; // 포인터간 거리 = 부분합의 개수

				min = Math.min(min, pnum); // 최소 부분합 개수 비교

				sum -= arr[lt++]; // 왼쪽 포인터 증가
			} else if (sum < S) {
				sum += arr[rt++]; // 오른쪽 포인터 증가
			}
		}

		if (min == Integer.MAX_VALUE) { // 최솟값의 변화가 없다면 0을 반환
			return 0;
		}

		return min;
	}

}
