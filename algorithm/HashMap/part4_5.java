package algorithm;

import java.util.*;
public class part4_5 {

	public static void main(String[] args){
		// K번째 큰 수
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int K = input.nextInt();
		
		int [] a = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i] = input.nextInt();
		}
		int answer = solution(a,N,K);
		System.out.print(answer);
		
	}
	private static int solution(int [] a , int N, int K) {
		int result = -1;
		int sum=0;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					sum = a[i] + a[j] + a[k];
					set.add(sum);
				}
			}
		}
		int cnt=0;
		for(int x : set) {
			cnt++;
			if(cnt==K) {
				result = x;
				break;
			}
		}	
		return result;
	}
}
