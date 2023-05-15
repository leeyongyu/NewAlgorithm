package algorithm.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class part10_6 {
	/**
	 * 시간내 최대점수 구할시 배열 스코어 끝에서부터 탐색해야 함!!!
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 최대점수 구하기(냅색 알고리즘)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 문제의 개수
		int M = Integer.parseInt(st.nextToken()); // 제한 시간

		int[] maxScore = new int[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			// !! 중요사항 - 배열 끝부터 탐색 !!
			for (int j = M; j >= time; j--) {
				// 현재 MAX 스코어보다 이전 시간의 스코어가 높다면
				maxScore[j] = Math.max(maxScore[j], maxScore[j - time] + score);
			}
		}
		System.out.println(maxScore[M]);
	}
}
