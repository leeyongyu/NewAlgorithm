package algorithm.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class part10_5 {

	public static void main(String[] args) throws IOException {
		// 동전 교환(냅색 알고리즘)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] dy = new int[M + 1];

		Arrays.fill(dy, Integer.MAX_VALUE); // 최소를 구할시 Dynamic 배열 최대값으로 초기화
		dy[0] = 0; // 첫번째 값은 0 (최소값)
		for (int i = 0; i < N; i++) {
			for (int j = arr[i]; j <= M; j++) {
				dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1); // (이전 최소값 + 1)이 현재 값보다 작다면 교환
			}
		}
		System.out.println(dy[M]);
	}
}
