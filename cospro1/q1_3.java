package cospro1;

public class q1_3 {
	private static boolean isTrue(int dx, int dy) {
		if (dx >= 0 && dx < 8 && dy > 0 && dy < 9) {
			return true;
		} else {
			return false;
		}
	}

	private static int solution(String pos) {
		// 나이트 위치
		int answer = 0;
		int x = 0, y = 0;
		int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
		String[] str = pos.split("");
		if ("A".equals(str[0])) {
			x = 1;
		} else if ("B".equals(str[0])) {
			x = 2;
		} else if ("C".equals(str[0])) {
			x = 3;
		} else if ("D".equals(str[0])) {
			x = 4;
		} else if ("E".equals(str[0])) {
			x = 5;
		} else if ("F".equals(str[0])) {
			x = 6;
		} else if ("G".equals(str[0])) {
			x = 7;
		} else if ("H".equals(str[0])) {
			x = 8;
		}
		y = 8 - Integer.parseInt(str[1]);
		// (-2,-1),(-1,-2),(1,-2),(2,-1),(-2,1),(-1,2),(1,2),(2,1)
		// dx>0 && dx<9 && dy > 0 && dy < 9
		for (int k = 0; k < dx.length; k++) {
			int ux = x + dx[k];
			int uy = y + dy[k];
			if (isTrue(ux, uy)) {
				answer++;
			}
		}
		return answer;
	}

	// The following is main method to output testcase.
	public static void main(String[] args) {
		String pos = "A7";
		int ret = solution(pos);

		// Press Run button to receive output.
		System.out.println("Solution: return value of the method is " + ret + " .");
	}

}
