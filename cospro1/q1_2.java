package cospro1;

public class q1_2 {
	// n-소용돌이
	private static int solution(int n) {
		// Write code here.
		int answer = 0;
		int[][] arr = new int[n][n];
		boolean[][] flag = new boolean[n][n];
		// 동쪽 > 남쪽> 서쪽 > 북쪽
		char[] dir = { 'E', 'S', 'W', 'N' };
		int max = n * n;
		int num = 1, i = 0, j = 0, idx = 0;
		while (num <= max) {
			arr[i][j] = num++;
			flag[i][j] = true;
			if (dir[idx] == 'E') {
				if (j + 1 < n && flag[i][j + 1] != true) {
					j++;
				} else {
					idx++;
					i++;
				}
			} else if (dir[idx] == 'S') {
				if (i + 1 < n && flag[i + 1][j] != true) {
					i++;
				} else {
					idx++;
					j--;
				}
			} else if (dir[idx] == 'W') {
				if (j - 1 > -1 && flag[i][j - 1] != true) {
					j--;
				} else {
					idx++;
					i--;
				}
			} else if (dir[idx] == 'N') {
				if (i - 1 > -1 && flag[i - 1][j] != true) {
					i--;
				} else {
					idx = 0;
					j++;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			for (int l = 0; l < arr[k].length; l++) {
				if (k == l) {
					answer += arr[k][l];
				}
				System.out.print(arr[k][l] + " ");
			}
			System.out.println();
		}
		return answer;
	}

	public static void main(String[] args) {
		int n1 = 4;
		int ret1 = solution(n1);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret1 + " .");

		int n2 = 2;
		int ret2 = solution(n2);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret2 + " .");
	}

}
