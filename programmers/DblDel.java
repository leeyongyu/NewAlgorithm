package programmers;

import java.util.Stack;

public class DblDel {

	public static void main(String[] args) {
		// 짝지어 제거하기(Level.2)
	}

	public int solution(String s) {
		int answer = 0; // 기본 리턴 0 세팅
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (i == 0) { // 첫번째 스택은 무조건 추가
				stack.push(ch[i]);
				continue; // 아래 조건 돌지 않고 i++
			}
			// 스택에 데이터가 들어 있고, 스택의 최상단값이 비교할 값과 같다면
			if (stack.size() > 0 && ch[i] == stack.peek()) {
				stack.pop(); // 스택의 최상단 값 제거
			} else { // 스택의 최상단값이 같지 않다면 스택에 추가
				stack.push(ch[i]);
			}
		}
		// 스택이 비어 있을시 모두 짝지은 문자이므로 제거 되어 1 리턴
		if (stack.size() == 0) {
			answer = 1;
		}

		return answer;
	}
}
