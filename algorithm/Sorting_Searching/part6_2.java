package algorithm;


import java.util.*;
public class part6_2 {

	public static void main(String[] args) {
		// 버블 정렬
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int [] a = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i] = input.nextInt();
		}
		int [] answer = solution(a,N);
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	private static int [] solution(int [] a, int n) {
		int tmp=0;
		for(int i=n-1; i>0; i--) { // 반복횟수를 -1씩 줄인다.
			for(int j=0, k=1; j<i; j++, k++) { // i번 앞뒤를 비교한다.
				if(a[j] > a[k]) { // 앞의 값이 크다면 스왑
					tmp = a[j];
					a[j] = a[k];
					a[k] = tmp;
				}
			}
		}
		return a;
	}
}
