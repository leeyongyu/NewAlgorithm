package algorithm;

import java.util.*;
public class part3_4 {

	public static void main(String[] args) {
		// 연속 부분수열
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		int [] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=input.nextInt();
		}
		int answer = solution(a,N,M);
		
		System.out.print(answer);
		
	}
	private static int solution(int [] a, int N, int M) {
		int result=0;
		int lt=0;
		int sum=0;
		for(int rt=0; rt<N; rt++) {
			sum+=a[rt];
			if(sum==M) {
				result++;
			}
			while(sum >=M) {
				sum-=a[lt++];
				if(sum==M) {
					result++;
				}
			}
		}
		return result;
	}
}
