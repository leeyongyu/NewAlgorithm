package cospro1;

import java.util.ArrayList;
import java.util.List;

public class q2_5 {

	private static int solution(int[] arr) {
		// 여기에 코드를 작성해주세요.
		List<Integer> list = new ArrayList<>();
		int len = 0, lt = 0, rt = 0;
		int answer = 0;
		while (lt < arr.length && rt < arr.length) {
			if (rt == (arr.length - 1)) {
				len = rt - lt;
				if (len > answer) {
					answer = len;
				}
				break;
			}
			if (arr[rt] < arr[rt + 1]) {
				rt++;
			} else {
				len = rt - lt;
				if (len > answer) {
					answer = len;
				}
				lt = rt;
				rt++;
			}
		}
		if (answer < 2) {
			answer = 1;
		}
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4, 5, 1, 2, 2, 3, 4 };
		int ret = solution(arr);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
