package algorithm;

import java.util.*;
public class part7_3 {

	public static void main(String[] args) {
		// 팩토리얼
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int answer = dfs(N);
		System.out.print(answer);
	}
	private static int dfs(int n) {
		if(n==1) {
			return n;
		}
		
		n = dfs(n-1)* n;
		
		return n;
		
	}
}
