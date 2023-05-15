package cospro1;

public class q3_4 {

	private static int solution(String s1, String s2) {
		// 여기에 코드를 작성해주세요.
		int answer = Math.min(calc(s1, s2), calc(s2, s1));

		return answer;
	}

	private static int calc(String s1, String s2) {
		int K = Math.min(s1.length(), s2.length());
		int m = Math.max(s1.length(), s2.length());
		int j = K;
		int len = 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++, j--) {
			String sub1 = s1.substring(i);
			String sub2 = s2.substring(0, j);
			if (sub1.equals(sub2)) {
				int tmp = sub1.length();
				if (len < tmp) {
					len = tmp;
					result = s1.length() + s2.length() - tmp;
				}
			}
		}
		return result;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String s1 = new String("ababc");
		String s2 = new String("abcdab");
		int ret = solution(s1, s2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
// 1. s1 + s2일때 , s2 + s1일때
// 2. s2는 s1의 최대길이부터 시작, -1씩 s2의 끝부터 감소, s1은 +1씩 증가