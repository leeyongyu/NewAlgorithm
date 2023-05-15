package algorithm;

import java.util.*;
public class part3_2 {

	public static void main(String[] args) {
		// 공통원소 구하기
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int [] arr1 =new int[N];
		for(int i=0; i<N; i++) {
			arr1[i]=input.nextInt();
		}
		int M = input.nextInt();
		int [] arr2 = new int[M];
		for(int i=0; i<M; i++) {
			arr2[i]=input.nextInt();
		}
		int [] answer = solution(N,arr1,M,arr2);
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}
	private static int [] solution(int N, int [] a, int M, int [] b) {
		List<Integer> list = new ArrayList<>();
		int p1 =0 , p2=0; // 투포인터 선언 
		// 오름차순 정렬
		Arrays.sort(a);  
		Arrays.sort(b);
		while(p1 < N && p2< M) { // 각 배열이 포인터가 끝을 바라보지 않는다면 
			if(a[p1] == b[p2]) {
				list.add(a[p1]);
				p1++; p2++;
			}else if(a[p1] < b[p2]) {
				p1++;
			}else if(a[p1] > b[p2]) {
				p2++;
			}
		}
		int [] result = new int[list.size()];
		for(int i=0; i< list.size(); i++) {
			result[i]=list.get(i);
		}
	
		return result;
	}
}
