package algorithm;

import java.util.Scanner;

public class part1_5 {

	public static void main(String[] args) {
		// 특정 문자 뒤집기
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		
		String output = solution(str);
		
		System.out.print(output);
	}
	private static String solution(String str) {
		String alphabet= "";
		String result = "";
		int idx=0;
		for(int i=str.length()-1; i>=0; i--) {
			if(Character.isAlphabetic(str.charAt(i))==true) {
				alphabet += str.charAt(i);
			}
		}
		for(int i=0; i<str.length(); i++) {
			if(Character.isAlphabetic(str.charAt(i))) {
				result+=alphabet.charAt(idx++);
			}else {
				result+=str.charAt(i);
			}
		}		
		return result;
	}
}
