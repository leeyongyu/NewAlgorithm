package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class baekjoon5597 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[] nums = new int[31];
		int[] inputs = new int[31];
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 28; i++) {
			int N = in.nextInt();
			inputs[N] = N;
		}
		for (int i = 1; i < nums.length; i++) {
			nums[i] = i;
		}
		for (int i = 1; i < inputs.length; i++) {
			if (inputs[i] != 0) {
				nums[i] = 0;
			}
		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != 0) {
				list.add(i);
			}
		}

		Collections.sort(list);

		System.out.println(list.get(0));
		System.out.print(list.get(1));
	}

}
