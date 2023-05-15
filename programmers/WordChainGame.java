package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordChainGame {

	public static void main(String[] args) {
		// 끝말잇기(level.2)

	}

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2]; // 결과 : 걸린사람, 회차

		List<String> wordlist = new ArrayList<>(); // words를 저장할 리스트
		Queue<Integer> queue = new LinkedList<>(); // 순서를 반복하기 위한 큐 선언
		int[] cnt = new int[n + 1]; // 각 순서마다의 회차 기록
		for (int i = 1; i <= n; i++) {
			queue.offer(i); // 초기 순서 세팅
		}
		int idx = 0; // words의 0번째 인덱스 선언
		char as = ' '; // 이전 단어의 마지막 단어 변수
		char to = ' '; // 현재 단어의 첫 번째 단어 변수
		while (idx < words.length) { // words의 배열을 다 돌떄까지 반복
			if (idx > 0) { // 2번째 인덱스부터 이전 단어와 비교
				as = words[idx - 1].charAt(words[idx - 1].length() - 1);// 이전 단어 마지막 글자
				to = words[idx].charAt(0); // 현재 단어 첫번째 글자
			}
			// 리스트에 반복되는 단어가 없고, 끝자리와 첫자리가 같은 경우만 다음 순서 반복
			if (wordlist.contains(words[idx]) != true && as == to) {
				int person = queue.peek(); // 해당 순서의 사람 번호
				wordlist.add(words[idx]); // 워드 추가
				queue.offer(queue.poll()); // 순서를 가장 뒤로
				cnt[person]++; // 해당 번째 순서의 회차 기록
			}
			// 단어가 리스트에 존재하거나, 끝자리와 첫자리 단어가 다른 경우 끝말잇기 종료
			else if (wordlist.contains(words[idx]) == true || as != to) {
				int person = queue.poll();
				cnt[person]++; // 해당 순서 회차 기록
				answer[0] = person; // 걸린 사람 번호
				answer[1] = cnt[person]; // 순서 회차
				break; // 종료
			}
			idx++;
		}
		// 정상적으로 다 돌았다면 끌맛잇기는 정상적으로 종료된것으로 0,0 리턴
		return answer;
	}

}
