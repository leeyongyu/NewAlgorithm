package algorithm.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class part5_3 {

	public static void main(String[] args) {
		// 크레인 인형뽑기(카카오)
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		int[][] a = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = input.nextInt();
			}
		}

		int K = input.nextInt();
		int[] b = new int[K];
		for (int i = 0; i < K; i++) {
			b[i] = input.nextInt();
		}
		int answer = solution(a, N, b, K);

		System.out.print(answer);
	}

	private static int solution(int[][] a, int N, int[] b, int K) {
		int result = 0;
		Stack<Integer> stack = new Stack<>(); // 스택선언
		int idx = 0; // 탐색할 배열 인덱스
		for (int i = 0; i < K; i++) { // b의 K번째까지 반복 탐색
			idx = 0; // 배열 인덱스 초기화
			// 2차원 행렬 b번째 행렬에 a의 0번째 행부터 인덱스로 순차적으로 탐색하여 0이 아닐때까지 탐색
			while (idx < N && a[idx][b[i] - 1] == 0) {
				idx++;
			}
			if (idx == N) { // 인덱스가 N까지 증가되었다면 b번째 행렬은 모두 0이므로 다음 for문 처리
				continue;
			}
			// 스택에 값이 들어있다면
			if (stack.size() != 0) {
				if (a[idx][b[i] - 1] == stack.peek()) { // 스택의 마지막 값과 현재 뽑은 a의 숫자가 같을 경우
					stack.pop(); // 스택에서 값을 제거
					result += 2; // 현재 뽑은 a를 추가하지 않고 결과값 +2
				} else { // 마지막 스택 값과 다르다면 값 추가
					stack.push(a[idx][b[i] - 1]);
				}
			} else { // 스택이 비어있다면 값 추가
				stack.push(a[idx][b[i] - 1]);
			}
			a[idx][b[i] - 1] = 0; // 뽑은 a의 행렬 값 0으로 초기화
		}

		return result;
	}
}
