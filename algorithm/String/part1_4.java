package algorithm.String;

import java.util.Scanner;

public class part1_4 {

	public static void main(String[] args) {
		// 단어 뒤집기
		Scanner input = new Scanner(System.in);

		int count = input.nextInt();
		String[] strArr = new String[count];

		for (int i = 0; i < count; i++) {
			strArr[i] = input.next();
		}

		solution(strArr);
	}

	private static void solution(String[] array) {
		for (int i = 0; i < array.length; i++) {
			String str = "";

			for (int j = array[i].length() - 1; j >= 0; j--) {
				str += array[i].charAt(j);
			}

			array[i] = str;
			System.out.println(array[i]);
		}
	}
}
