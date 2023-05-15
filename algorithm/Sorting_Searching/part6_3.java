package algorithm;


import java.util.*;
public class part6_3 {

	public static void main(String[] args) {
		// 삽입 정렬
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int [] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i]=input.nextInt();
		}
		int [] answer=solution(a,N);
		for(int i=0; i<N; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	private static int [] solution(int [] a, int n) {
		int tmp=0;
		for(int i=1; i<n; i++) { // 1~N까지 반복
			for(int j=i; j>0; j--) { // i번째부터 1번째까지 반복
				if(a[j-1] > a[j]) { // 앞의 숫자가 크다면 스왑
					tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
	}
}
