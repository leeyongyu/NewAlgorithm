package cospro1;

public class q2_4 {

	private static int solution(int[] arr, int K) {
		// 여기에 코드를 작성해주세요.
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if ((arr[i] + arr[j] + arr[k]) % K == 0) {
						answer++;
					}
				}
			}
		}
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int K = 3;
		int ret = solution(arr, K);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
	}
}
