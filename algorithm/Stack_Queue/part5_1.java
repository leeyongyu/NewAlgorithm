package algorithm.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class part5_1 {

	public static void main(String[] args) {
		// 올바른 괄호
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();

		String answer = solution(str);
		System.out.print(answer);

	}

	private static String solution(String str) {
		String result = "YES";

		Stack<Character> stack = new Stack<>();

		for (Character ch : str.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				// 스택에 값이 없을때를 처리한다.(처리 안할시 런타임오류)
				if (stack.isEmpty() == true) {
					result = "NO";
					break;
				}
				stack.pop();
			}
		}
		// 최종적으로 처리했으나 값이 남아있다면 괄호가 맞지 않음
		if (stack.isEmpty() != true) {
			result = "NO";
		}
		return result;
	}
}
