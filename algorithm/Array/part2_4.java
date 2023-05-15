package algorithm;

import java.util.*;
public class part2_4 {
final static int [] num = new int[46];
	public static void main(String[] args) {
		// 피보나치수열
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int [] numArr = solution(n);
		
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i] +" ");
		}
	}
	private static int [] solution(int n) {
		int [] numArr = new int[n];
		for(int i=0; i<numArr.length; i++) {
			numArr[i]=fibo(i);
		}
		
		return numArr;
	}
	private static int fibo(int n) {
		if(n==0 || n==1) {
			num[n]=1;
			return num[n];
		}else if(num[n] != 0){
			return num[n];
		}
		
		return num[n] = fibo(n-2) + fibo(n-1);	
	}
}
