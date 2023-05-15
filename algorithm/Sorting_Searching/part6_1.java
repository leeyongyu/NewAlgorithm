package algorithm;

import java.util.*;
public class part6_1 {

	public static void main(String[] args) {
		// 선택 정렬
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int [] intarr = new int[N];
		
		for(int i=0; i<N; i++) {
			intarr[i] = input.nextInt();
		}
		int [] arr = solution(intarr,N);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static int [] solution(int [] a, int n) {
		int min=0;
		int tmp=0;
		// 선택정렬은 앞부터 하나씩 비교하여 서로간의 위치를 바꾼다.(모든 경우 탐색)
		for(int i=0; i<n; i++){
			min=a[i]; // 최솟값 초기화
			for(int j=i+1; j<n; j++) {
				if(min > a[j]) {
					tmp = a[i]; // 앞의 값 임시 저장
					min = a[j]; // 최소는 비교하는 뒤의 값
					a[i] = a[j]; // 뒤의 값 을 앞에 값에 덮어쓰기
					a[j] = tmp; // 뒤의 값을 임시저장한 앞의값 추가
				}
			}
		}
		return a;
	}
}
