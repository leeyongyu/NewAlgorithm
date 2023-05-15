package algorithm;

import java.util.*;
public class part3_3 {

	public static void main(String[] args) {
		// 최대 매출
		Scanner input =new Scanner(System.in);
		
		int N = input.nextInt();
		int K = input.nextInt();
		
		int [] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=input.nextInt();
		}
		int answer = solution(N,K,a);
		System.out.print(answer);
		
	}
	private static int solution(int N, int K, int [] a) {
		int result=0;
		int sum=0;
		for(int i=0; i<K; i++) {
			sum+=a[i];
		}
		result=sum; // 첫번째 윈도우 sum 계산
		int p1=K; // 포인터는 두번째 윈도우 K번째를 바라본다.
		while(p1 < N) {
			// 한칸씩 옮기며 마지막 행(p1)은 더하고 첫번째 행(p1-k)은 뺀다.
			sum += (a[p1] - a[p1-K]);
			if(result <sum) { // 해당 윈도우가 가장 크다면 값 변경
				result=sum;
			}
			p1++; //포인터 증가 
		}
		
		return result;
	}
}
