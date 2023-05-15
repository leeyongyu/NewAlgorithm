package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon20154 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String str = in.nextLine();

		char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int[] numberList = { 3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			for (int j = 0; j < alphabet.length; j++) {
				if (ch == alphabet[j]) {
					queue.offer(numberList[j]);
				}
			}
		}
		if (queue.size() == 1) {
			int num = queue.poll();
			if (num > 10) {
				num = num % 10;
			}
			if (num % 2 == 0) {
				System.out.print("You're the winner?");
			} else {
				System.out.print("I'm a winner!");
			}
		} else if (queue.size() > 1) {
			while (queue.size() != 1) {
				int len = queue.size();
				int count = 0;
				int idxCnt = len / 2;
				while (count != idxCnt) {
					int a = queue.poll();
					int b = queue.poll();
					queue.offer(a + b);
					count++;
				}
				if (len % 2 == 1) {
					queue.offer(queue.poll());
				}
			}
			int newNum = queue.poll();
			if (newNum > 10) {
				newNum = newNum % 10;
			}
			if (newNum % 2 == 0) {
				System.out.print("You're the winner?");
			} else {
				System.out.print("I'm a winner!");
			}
		}
	}

}
