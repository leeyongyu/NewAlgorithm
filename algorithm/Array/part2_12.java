package algorithm;

import java.util.*;
public class part2_12 {

	public static void main(String[] args) {
		// 멘토링
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int h = input.nextInt();
		
		int [][] arr = new int[h][n];
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]=input.nextInt();
			}
		}
		int answer = solution(arr,n,h);
		
		System.out.print(answer);
	}
	private static int solution(int [][] arr, int N, int h) {
		int result=0;
		int idx=99999;
		for(int i=1; i<=N; i++) { // 1~N 숫자마다 비교
			int [] flag = new int[N+1]; 
			for(int j=0; j<h; j++) { // 테스트 숫자만큼 반복
				idx=99999; // 비교를 위해 임의로 큰 수 설정
				for(int k=0; k<N; k++) { // 행 숫자 비교
					if(arr[j][k] == i) { // i의 인덱스 저장
						idx= k;
					}
					if(idx < k) { // 비교 숫자보다 인덱스가 뒤에 있다면
						flag[arr[j][k]]++; // 카운트 증가
					}
				}
			}
			for(int l=1; l<flag.length; l++) {
				if(flag[l]==h) { // 숫자 카운트가 테스트 횟수라면 참
					result++;
				}
			}
		}
		
		return result;
	}
}
