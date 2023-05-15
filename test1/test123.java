package test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test123 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int answer = 0;
		int seq = 0;
		int result = 0;
		int cnt = 0;
		int[][] arr = new int[5][5];
		int[][] p = new int[5][5];
		for (int i = 0; i < 5; i++) {
			int j = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			int k = 0;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			while (st2.hasMoreTokens()) {
				p[i][k++] = Integer.parseInt(st2.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			answer = 0;
			for (int j = 0; j < 5; j++) {
				seq++;
				answer = 0;
				for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (arr[k][l] == p[i][j]) {
							arr[k][l] = 0;
							break;
						}
					}
				}
				for (int m = 0; m < 5; m++) { // col
					cnt = 0;
					for (int n = 0; n < 5; n++) {
						if (arr[m][n] == 0) {
							cnt++;
						}
					}
					if (cnt == 5) {
						answer++;
					}
				}
				for (int m = 0; m < 5; m++) { // row
					cnt = 0;
					for (int n = 0; n < 5; n++) {
						if (arr[n][m] == 0) {
							cnt++;
						}
					}
					if (cnt == 5) {
						answer++;
					}
				}
				cnt = arr[4][0] + arr[3][1] + arr[2][2] + arr[1][3] + arr[0][4];
				if (cnt == 0) {
					answer++;
				}
				cnt = arr[0][0] + arr[1][1] + arr[2][2] + arr[3][3] + arr[4][4];
				if (cnt == 0) {
					answer++;
				}
				if (answer >= 3) {
					result = seq;
					break;
				}
			}
			if (answer >= 3) {
				break;
			}
		}
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}
}