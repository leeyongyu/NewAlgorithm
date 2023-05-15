package algorithm;

import java.util.Scanner;

public class part1_3 {

	public static void main(String[] args) {
		// 문장 속 단어
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();
		
		System.out.print(solution(str));
	}
	public static String solution(String str) {
		String [] strArr = str.split(" ");
		int maxlength=0;
		String result="";
		
		for(int i=0; i<strArr.length; i++) {
			if(maxlength <strArr[i].length()) {
				maxlength = strArr[i].length();
			}
		}
		
		for(int i=0; i<strArr.length; i++) {
			if(maxlength == strArr[i].length()) {
				result = strArr[i];
			}
		}
		
		return result;
	}
}
