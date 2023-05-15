package algorithm;

import java.util.*;
public class part5_4 {

	public static void main(String[] args) {
		// 후위식 연산(postfix)
		Scanner input = new Scanner(System.in);
		
		String a = input.nextLine();
		int answer = solution(a);
		System.out.print(answer);
	}
	private static int solution(String a) {
		int result=0;
		Stack<Integer> stack = new Stack<>();
		int sum=0;
		int num1=0 , num2=0;
		for(Character ch : a.toCharArray()) {
			if(Character.isDigit(ch) == true) {
				stack.push(Character.getNumericValue(ch));
			}else {
				if(ch == '+') {
					num1= stack.pop(); 
					num2= stack.pop();
					sum =(num2 + num1);
					stack.push(sum);
				}else if(ch == '-') {
					num1= stack.pop();
					num2= stack.pop();
					sum =(num2 - num1);
					stack.push(sum);
				}else if(ch == '*') {
					num1= stack.pop();
					num2= stack.pop();
					sum =(num2 * num1);
					stack.push(sum);
				}else if(ch == '/') {
					num1= stack.pop();
					num2= stack.pop();
					sum =(num2 / num1);
					stack.push(sum);
				}
			}
		}
		result = stack.pop();		
		return result;
	}
}
