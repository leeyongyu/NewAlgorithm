package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FuncDevel {

	public static void main(String[] args) {
		// 기능개발(Level.2)
	}

	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {}; // 결과값 배열 선언
		Queue<Integer> queue = new LinkedList<>(); // 큐 선언
		int cnt = 0; // 각 프로그레스가 스피드로 몇 회 돌았는지 카운트할 변수
		for (int i = 0; i < progresses.length; i++) {
			cnt = 0; // 횟수 초기화
			while (progresses[i] < 100) { // 프로그레스가 100보다 작다면 반복
				progresses[i] += speeds[i]; // 스피드를 반복해서 증가
				cnt++; // 횟수 카운트 증가
			}
			queue.offer(cnt); // 각 프로그레스 100이 되기위한 횟수 카운트 저장
		}
		List<Integer> list = new ArrayList<>();
		int max = queue.peek(); // 비교를 위한 첫 숫자는 큐의 첫번째 값
		cnt = 0; // 카운트 초기화
		while (queue.isEmpty() != true) {
			if (max < queue.peek()) { // 큐의 횟수 카운트가 더 큰 숫자가 있다면
				max = queue.poll(); // 최대 값은 해당 값
				list.add(cnt); // 최대값을 만나면 카운트 한 이전 값을 저장한다.
				cnt = 0; // 다음 최대값 이후로 카운트 초기화
			} else {
				queue.poll(); // 최대값보다 작은 횟수라면 그대로 꺼낸다.
			}
			cnt++; // 모든 경우 카운트 증가
			if (queue.size() == 0) { // 마지막 큐 처리문
				list.add(cnt); // 앞에서 계산된 카운트를 넣는다.
			}
		}
		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
