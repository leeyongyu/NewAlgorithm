package programmers;

import java.util.ArrayList;
import java.util.List;

public class WordCompress {

	public static void main(String[] args) {
		// 문자열 압축

	}

	public int solution(String s) {
		int answer = Integer.MAX_VALUE; // 최대 숫자 길이 임의로 설정
		List<String> slist = new ArrayList<>();
		String str = ""; // 글자 개수별로 나눈 문자를 저장할 변수
		String nstr = ""; // 새로 조립될 문자를 저장할 변수
		int cnt = 1; // 문자의 개수를 세는 카운트 변수
		if (s.length() == 1) { // 테스트케이스 5번 예외처리
			return 1; // 글자가 1개일때에는 조건문을 돌지 않는다.
		}
		for (int i = 1; i < s.length(); i++) { // 자를 글자 수 = i
			for (int j = 0; j < s.length(); j += i) { // j는 글자수 +i 만큼 증가
				if (j + i < s.length()) { // 글자열이 최대 문자길이를 안넘긴다면
					str = s.substring(j, j + i); // 글자수 i 만큼 잘라서 저장
				} else { // 자를 글자열이 최대 문자길이를 넘어간다면
					str = s.substring(j, s.length()); // 남은 마지막 문자까지 저장
				}
				slist.add(str); // 리스트에 자른 글자열 저장
			}
			for (int k = 0; k < slist.size() - 1; k++) { // k+1과 비교하므로 size()-1 까지 비교
				// 리스트에 저장한 단어 문자열 i번째와 i+1번째가 같다면
				if (slist.get(k).equals(slist.get(k + 1))) {
					cnt++; // 카운트 증가 (초기 카운트=1, 따라서 2이상)
				} else { // 다음 문자열 리스트와 같지 않다면
					if (cnt > 1) { // 같은 문자열 카운트가 2 이상이라면
						nstr += cnt + slist.get(k); // 숫자 + 문자열 저장
					} else { // 같은 문자열 카운트가 1, 즉 없다면
						nstr += slist.get(k); // k-1에서 초기화한 글자 출력
					}
					cnt = 1; // 다음 문자열 k+1의 카운트 초기화
				}
				// 마지막 size-2 인덱스 처리(마지막 문자열 출력)
				if ((k + 1) == slist.size() - 1) {
					if (cnt > 1) {
						nstr += cnt + slist.get(k + 1);
					} else {
						nstr += slist.get(k + 1);
					}
				}
			}
			// 기존에 저장한 문자열의 길이보다 작다면 결과값 변경
			if (answer > nstr.length()) {
				answer = nstr.length();
			}
			slist.clear(); // 리스트 초기화
			nstr = ""; // 문자열 초기화
			cnt = 1; // 카운트 변수 초기화
		}
		return answer;
	}
}
