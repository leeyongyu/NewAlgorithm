package cospro1;

public class q3_5 {

	private static String solution(String phrases, int second) {
		// 여기에 코드를 작성해주세요.
		String answer = "";
		int len = phrases.length();
		String tmp = "";
		int s = second % (len * 2);
		for (int i = 0; i < len; i++) {
			answer += "_";
		}
		if (s <= len) {
			tmp = phrases.substring(0, s);
			answer = answer.substring(0, len - s) + tmp;

		} else if (s > len) {
			tmp = phrases.substring(s - len - 1, len);
			answer = tmp + answer.substring(len);
		}
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String phrases = new String("happy-birthday");
		int second = 16;
		String ret = solution(phrases, second);
		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
