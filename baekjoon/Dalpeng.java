package baekjoon;

import java.util.Scanner;

public class Dalpeng {

	public static void main(String[] args) {
		// 달팽이 (벡준 실버4 구현)
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int num = in.nextInt();

		int[][] arr = new int[N][N];
		char[] dir = { 'W', 'N', 'E', 'S' }; // 방향을 가리킬 서,북,동,남 변수
		int lnum = N * N; // (0,0) 초기입력숫자
		int idx = 3, i = 0, j = 0; // 방향 인덱스(3='남'), 배열 인덱스 선언
		boolean[][] flag = new boolean[N][N]; // 방문했는지 여부 이차원배열
		while (lnum > 0) { // 1보다 작으면 멈춤.
			arr[i][j] = lnum;
			flag[i][j] = true;

			// 남쪽일때 인덱스처리
			if (dir[idx] == 'S') {
				if (i + 1 < N && flag[i + 1][j] == false) {
					i++;
				} else {
					idx--;
					j++;
				}
			}
			// 동쪽일때 인덱스처리
			else if (dir[idx] == 'E') {
				if (j + 1 < N && flag[i][j + 1] == false) {
					j++;
				} else {
					idx--;
					i--;
				}
			}
			// 북쪽일때 인덱스처리
			else if (dir[idx] == 'N') {
				if (i - 1 > -1 && flag[i - 1][j] == false) {
					i--;
				} else {
					idx--;
					j--;
				}
			}
			// 서쪽일때 인덱스처리
			else if (dir[idx] == 'W') {
				if (j - 1 > -1 && flag[i][j - 1] == false) {
					j--;
				} else {
					idx = 3;
					i++;
				}
			}
			lnum--;
		}
		int row = 0;
		int col = 0;
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N; l++) {
				sb.append(Integer.toString(arr[k][l]) + " "); // System.out을 사용하면 타임아웃이 나므로 StringBuilder 사용.
				if (num == arr[k][l]) {
					row = k + 1; // 발견하고 싶은 숫자의 행
					col = l + 1; // 발견하고 싶은 숫자의 열
				}
			}
			sb.append("\n");
		}
		System.out.print(sb); // StringBuilder를 사용하여 한번에 출력
		System.out.print(row + " " + col); // 찾고자 하는 숫자 행,열 출력
	}
}
