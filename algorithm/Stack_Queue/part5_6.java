package algorithm;

import java.util.*;
public class part5_6 {

	public static void main(String[] args) {
		// 공주 구하기
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int [] a = new int[N];
		for(int i=0; i<a.length; i++) {
			a[i]=i+1;
		}
		int K = input.nextInt();
		int answer = solution(a,K);
		
		System.out.print(answer);
	}
	private static int solution(int [] arr, int k) {
		int result =0;
		Queue<Integer> que = new LinkedList<>();
		
		// 큐 초기값 추가(왕자들의 배열)
		for(int i=0; i<arr.length; i++) {
			que.add(arr[i]);
		}
		int num=0;
		while(que.size() != 1) { // 큐의 사이즈가 1개가 남을때까지 반복
			for(int i=0; i<k; i++) {
				if(i != k-1) { // K-1개 추가 
					num = que.peek();
					que.add(num);
				}
				que.poll(); //K개 제거
			}			
		}
		result = que.poll(); // 마지막 큐 결과값 추가 
		return result;
	}
}
