package cospro1;

public class q1_1 {

	private static long solution(long num) {
		// Write code here.
		long answer = 0;
		answer = num + 1;
		StringBuilder sb = new StringBuilder();
		String[] str = Long.toString(answer).split("");
		for (int i = 0; i < str.length; i++) {
			if ("0".equals(str[i])) {
				str[i] = "1";
			}
			sb.append(str[i]);
		}
		answer = Integer.parseInt(sb.toString());

		return answer;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		long num = 9949999;
		long ret = solution(num);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret + " .");
	}
}
