package algorithm;

import java.util.*;
public class part7_2 {

	public static void main(String[] args) {
		// 재귀함수를 이용한 이진수 출력
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		recursive(N);
	}
	private static void recursive(int n) {
		if(n ==0) {
			return;
		}
		recursive(n/2);
		System.out.print(n%2);		
	}
}
