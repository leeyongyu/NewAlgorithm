package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class WordReverse2 {

	public static void main(String[] args) {
		// 단어 뒤집기2
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		String result = solution(str);
		System.out.print(result);
	}

	public static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean flag = false; // tag가 아닐때 false
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '<') {
				flag = true; // tag일때 true
				// 태그전에 들어온 글자가 있을경우 스택 출력
				while (stack.isEmpty() != true) {
					answer.append(stack.pop());
				}
				answer.append(ch); // '<' 추가
				continue;
			} else if (ch == '>') {
				flag = false; // '>' 일때 tag가 종료됨을 알림
				answer.append(ch);
				continue;
			}
			// tag가 종료됬으나 tag 밖 글자가 공백을 가진다면 공백을 기준으로 역순출력해야하므로
			else if (flag == false && ch == ' ') {
				flag = false;
				// 스택에 들어온 값 역순 출력
				while (stack.isEmpty() != true) {
					answer.append(stack.pop());
				}
				answer.append(ch); // ' ' 추가
				continue;
			}
			if (flag == true) { // tag 안이라면
				answer.append(ch); // 정상출력
			} else if (flag == false) { // tag 밖이라면
				stack.push(ch); // 역순출력을 위한 스택 추가
				// 마지막 행 처리(index가 마지막이면 종료하므로.)
				if (i == s.length() - 1) {
					while (stack.isEmpty() != true) {
						answer.append(stack.pop());
					}
				}
			}

		}
		return answer.toString();
	}
}
