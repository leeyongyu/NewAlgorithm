package algorithm;

import java.util.*;

public class part1_6 {

	public static void main(String[] args) {
		// 중복문자제거
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		
		System.out.print(solution(str));
	}
	private static String solution(String str) {
		String result="";
		
		List<Character> list = new ArrayList<>();
		
		for(int i=0; i<str.length(); i++) {
			if(list.contains(str.charAt(i)) != true) {
				list.add(str.charAt(i));
			}
		}
		for(Character c: list) {
			result+=c;
		}
		return result;
	}
}
