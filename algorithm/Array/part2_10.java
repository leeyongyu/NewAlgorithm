package algorithm;


import java.util.*;
public class part2_10 {

	public static void main(String[] args) {
		// 봉우리
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int [][] numArr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				numArr[i][j] = input.nextInt();
			}
		}
		int answer=solution(numArr, n);
		
		System.out.print(answer);

	}
	private static int solution(int [][] arr, int n) {
		int [] dx = {-1, 0, 1, 0};
		int [] dy = {0, 1, 0, -1};
		int answer=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean flag=true;
				for(int k=0; k<4; k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>=arr[i][j]) {
						flag=false;
						break;
					}
				}
				if(flag) answer++;
			}
		}
		return answer;
	}
}
