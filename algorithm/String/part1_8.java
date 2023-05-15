package algorithm;

import java.util.Scanner;

public class part1_8 {

	public static void main(String[] args) {
		// 펠린드롬
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();
		
		System.out.print(solution(str));
	}
	private static String solution(String str) {
		String result="NO";
		
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		
		String reverse = new StringBuilder(str).reverse().toString();
		
		if(reverse.equals(str)== true) {
			result="YES";
		}
		return result;
	}
}
