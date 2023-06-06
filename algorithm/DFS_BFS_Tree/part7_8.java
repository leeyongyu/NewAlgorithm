package algorithm.DFS_BFS_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class part7_8 {
	static int K; // 송아지 위치
	static int level; // 레벨(점프횟수)

	public static void main(String[] args) {
		// 송아지 찾기1(BFS)
		Scanner input = new Scanner(System.in);

		int N = input.nextInt(); // 철수의 위치
		K = input.nextInt(); // 송아지의 위치
		bfs(N);
	}

	private static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<>();
		int min = Integer.MAX_VALUE; // 최소 거리 변수
		queue.offer(N); // 철수의 위치 N 삽입
		while (queue.peek() != K) { // 철수의 위치가 송아지의 위치가 아닐동안 반복
			int cur = queue.peek(); // 철수의 현재 위치 변수
			min = Integer.MAX_VALUE; // 최소 거리 변수 초기화
			queue.offer(cur + 1); // 점프 +1
			queue.offer(cur - 1); // 점프 -1
			queue.offer(cur + 5); // 점프 +5
			int len = queue.size(); // 큐의 경우 사이즈
			for (int i = 0; i < len; i++) {
				int num = Math.abs(K - queue.peek()); // 최소거리 변수(송아지의 위치-철수의 점프 후 위치)
				if (min > num) { // 최소 거리를 저장
					min = num;
				}
				queue.offer(queue.poll()); // 큐의 변수를 한바퀴 돌린다.
			}
			for (int i = 0; i < len; i++) {
				// 지정한 최소거리가 아니라면 큐에서 제거
				if (min != Math.abs(K - queue.peek())) {
					queue.poll();
				} else {
					// 지정한 최소거리라면 큐에 다시 넣는다.
					queue.offer(queue.poll());
				}
			}
			// 한번 다 돌았을시 점프후 최소거리 변수만 큐에 남음.
			level++; // 횟수 카운트 증가
		}
		System.out.print(level);
	}
}
