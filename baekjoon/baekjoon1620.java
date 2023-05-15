package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baekjoon1620 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int N = input.nextInt();
		int M = input.nextInt();

		input.nextLine();

		String[] arr = new String[N + 1];

		Map<Integer, String> iMap = new HashMap<>(); // key=숫자
		Map<String, Integer> sMap = new HashMap<>(); // key=문자

		for (int i = 1; i < arr.length; i++) {
			arr[i] = input.nextLine();
			iMap.put(i, arr[i]);
			sMap.put(arr[i], i);
		}

		String[] finds = new String[M];

		for (int i = 0; i < finds.length; i++) {
			finds[i] = input.nextLine();
			if (isNumeric(finds[i])) { // key가 숫자일때
				int num = Integer.parseInt(finds[i]);
				System.out.println(iMap.get(num));
			} else { // key가 문자일때
				System.out.println(sMap.get(finds[i]));
			}
		}

	}

	// 문자열 숫자 판별 함수
	private static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
