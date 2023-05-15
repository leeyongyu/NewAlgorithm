package algorithm;

import java.util.*;
public class part2_5 {

	public static void main(String[] args) {
		// 소수(에라토스테네스 체)
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int num = solution(n);
		
		System.out.print(num);
	}
	private static int solution(int n) {
		int result=0;
		int [] numArr = new int[n+1];
		for(int i=2; i<=n; i++) {
			if(numArr[i]==0) {
				result++;
				for(int j=i; j<=n; j=j+i) {
					numArr[j]=1;
				}
			}
		}
		return result;
	}
}