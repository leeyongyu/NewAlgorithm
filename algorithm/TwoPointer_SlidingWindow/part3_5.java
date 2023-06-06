package algorithm.TwoPointer_SlidingWindow;

import java.util.Scanner;

public class part3_5 {

	public static void main(String[] args) {
		// 연속된 자연수의 합
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int answer = solution(n);

		System.out.print(answer);

	}

	private static int solution(int n) {
		int result = 0;
		int sum = 1;
		int lt = 1, rt = 1;

		while (lt < n && rt < n) {
			if (sum == n) {
				// n이 되는 sum은 결과값 증가
				result++;
				// 다음 연속된 숫자를 구하기위하여 왼쪽 포인터 lt 값을 뺀다.
				sum -= lt;
				lt++; // 다음값을 위한 왼쪽 포인터 증가
			} else if (sum < n) { // n이 안된다면
				++rt; // 오른쪽 포인터 증가
				sum += rt; // 증가 된 값을 sum에 추가
			} else if (sum > n) { // n을 초과한다면
				sum -= lt; // 왼쪽 포인터 lt 값을 n이 되거나 작게 될때까지 뺀다.
				lt++; // 왼쪽 포인터 증가
			}
		}
		return result;
	}
}
