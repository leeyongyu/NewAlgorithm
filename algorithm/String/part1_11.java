package algorithm;

import java.util.*;

public class part1_11 {

	public static void main(String[] args) {
		// 문자열 압축
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		System.out.print(solution(str));
	}
	private static String solution(String str) {
		char [] charArr = str.toCharArray();
		String result="";
		String newstr="";
		int idx=0;
		for(int i=0; i<str.length(); i++) {
			if(i==0) {
				newstr+=charArr[i];
			}else if(newstr.charAt(newstr.length()-1) != charArr[i]) {
				newstr+=charArr[i];
			}
		}
		int [] idxCnt = new int[newstr.length()];
		idx=0;
		for(int i=0; i<str.length(); i++) {
			if(i==0) {
				idxCnt[idx]++;
			}else if(str.charAt(i) == str.charAt(i-1)) {
				idxCnt[idx]++;
			}else if(str.charAt(i) != str.charAt(i-1)) {
				idx++;
				idxCnt[idx]++;
			}
		}
		idx=0;
		for(int i=0; i<newstr.length(); i++) {
			result+=newstr.charAt(i);
			if(idxCnt[idx]>1) {
				result+=Integer.toString(idxCnt[idx]);
			}
			idx++;
		}
		return result;
	}
}
