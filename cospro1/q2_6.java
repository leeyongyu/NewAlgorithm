package cospro1;

import java.util.Arrays;

public class q2_6 {

	private static int[] solution(String commands) {
		// 여기에 코드를 작성해주세요.
		int[] answer = new int[2];
		int x = 0, y = 0;
		char[] ch = commands.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'L') {
				x -= 1;
			} else if (ch[i] == 'R') {
				x += 1;
			} else if (ch[i] == 'U') {
				y += 1;
			} else if (ch[i] == 'D') {
				y -= 1;
			}
		}
		answer[0] = x;
		answer[1] = y;
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String commands = "URDDL";
		int[] ret = solution(commands);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
	}

}
