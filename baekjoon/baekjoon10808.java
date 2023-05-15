package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class baekjoon10808 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		HashMap<Character, Integer> map = new HashMap<>();

		String str = input.nextLine();

		char ch = 'a';
		for (int i = (int) 'a'; i <= (int) 'z'; i++) {
			map.put(ch, 0);
			ch++;
		}

		for (int i = 0; i < str.length(); i++) {
			char chAt = str.charAt(i);
			map.put(chAt, map.getOrDefault(chAt, 0) + 1);
		}

		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(map.get(c) + " ");
		}
	}
}
