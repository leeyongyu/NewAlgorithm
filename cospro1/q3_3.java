package cospro1;

public class q3_3 {

	private static int solution(String[] bishops) {
		// 여기에 코드를 작성해주세요.
		// (-1,-1),(-1,1),(1,-1),(1,1)
		boolean[][] flag = new boolean[8][8];
		for (int i = 0; i < bishops.length; i++) {
			int x = bishops[i].charAt(0) - 'A';
			int y = Character.getNumericValue(bishops[i].charAt(1)) - 1;
		}
		int answer = 0;
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		String[] bishops1 = { new String("D5") };
		int ret1 = solution(bishops1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		String[] bishops2 = { new String("D5"), new String("E8"), new String("G2") };
		int ret2 = solution(bishops2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
	}
}
