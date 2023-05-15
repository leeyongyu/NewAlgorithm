package algorithm;

import java.util.*;
public class part2_3 {

	public static void main(String[] args) {
		// 가위바위보
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int [] a = new int[n];
		int [] b = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = input.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = input.nextInt(); 
		}
		char [] winner = solution(a,b,n);
		
		for(int i=0; i<winner.length; i++) {
			System.out.println(winner[i]);
		}

	}
	private static char [] solution(int [] a, int [] b, int n) {
		char [] result = new char[n];
		
		for(int i=0; i<n; i++) {	
			result[i] = iswhoWin(a[i],b[i]);
		}
		
		return result;
	}
	private static char iswhoWin(int a, int b) {
		char winner = ' ';
		if((a==1 && b==2) || (a==2 && b==3) || (a==3 && b==1)) {
			winner='B';
		}else if(a==1 && b==3 || (a==2 && b==1) || (a==3 && b==2)) {
			winner='A';
		}else if(a==b) {
			winner='D';
		}
		return winner;
	}
}
