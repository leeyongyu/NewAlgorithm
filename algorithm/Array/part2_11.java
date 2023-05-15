package algorithm;

import java.util.*;
public class part2_11 {

	public static void main(String[] args) {
		// 임시반장정하기
		Scanner input= new Scanner(System.in);
		
		int n=input.nextInt();
		int [][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		int answer = solution(arr,n);
		System.out.print(answer);

	}
	private static int solution(int [][] arr, int n) {
		int cnt=0;
		int max=0;
		int result=0;
		for(int i=0; i<n; i++) {
			cnt=0;
			for(int j=0; j<n; j++) {
				if(i==j) {
					continue;
				}
				for(int k=0; k<n; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}				
				}
				if(cnt>max) {
					max=cnt;
					result=i+1;
				}
			}
		}
		return result;
	}
}
