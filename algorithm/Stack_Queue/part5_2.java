package algorithm;

import java.util.*;
public class part5_2 {

	public static void main(String[] args) {
		// 괄호문자제거
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();
	
		String answer = solution(str);
		System.out.print(answer);

	}
	private static String solution(String str) {
		String result="";
		Stack<Character> stack = new Stack<>();
		for(Character ch : str.toCharArray()) {
			if(ch != ')') { // 닫는 가로가 아니라면 스택에 추가
				stack.push(ch);
			}else { // 닫는 가로일시 닫는가로가 아닐동안 스택 제거
				while(stack.peek() != '(') {
					stack.pop();
				}
				// while문 종료시 닫는 가로를 만나므로 제거
				if(stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		for(int i=0; i<stack.size(); i++) {
			if(stack.isEmpty() != true) {
				result+= stack.get(i); // stack.pop() 사용시 size가 바뀌므로 제대로 출력 안됨.
			}
		}
						
		return result;
	}
}
