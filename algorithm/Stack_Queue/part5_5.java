package algorithm.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class part5_5 {

	public static void main(String[] args) {
		// 쇠막대기
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		int answer = solution(str);
		System.out.print(answer);

	}

	private static int solution(String s) {
		int result = 0;
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(') {
				stack.push(ch[i]);
			} else if (ch[i] == ')') {
				stack.pop();
				if (ch[i - 1] == '(') { // 레이저일경우
					result += stack.size(); // 스택의 사이즈만큼 증가
				} else { // 레이저가 아닐경우(막대의종료)
					result++; // 막대의 끝으로 +1 증가
				}
			}
		}
		return result;
	}
}
