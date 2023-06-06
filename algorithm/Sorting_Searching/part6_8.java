package algorithm.Sorting_Searching;

import java.util.Arrays;
import java.util.Scanner;

public class part6_8 {

	public static void main(String[] args) {
		// 이분검색
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int M = input.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		int answer = solution(arr, N, M);

		System.out.print(answer);
	}

	private static int solution(int[] a, int N, int K) {
		Arrays.sort(a); // 숫자 오름차순 정렬
		int result = 0;
		int idx = 0; // 탐색할 인덱스 변수 선언
		int lt = 0, rt = N - 1; // 배열 투포인터 선언
		while (a[idx] != K) { // K일때까지 이분검색
			idx = (lt + rt) / 2; // 이분검색을 통한 배열의 중앙값 인덱스
			if (a[idx] == K) { // K일시 종료
				result = idx + 1;
				break;
			}
			if (a[idx] < K) { // 중앙값이 K보다 작다면
				lt = idx + 1; // 오른쪽을 탐색해야 하므로 lt 포인터 재선언
			} else if (a[idx] > K) { // 중앙값이 K보다 크다면
				rt = idx - 1; // 왼쪽을 탐색해야 하므로 rt 포인터 재선언
			}
		}
		return result;
	}
}
