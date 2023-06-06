package algorithm.HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class part4_4 {

	public static void main(String[] args) throws IOException {
		// 모든 아나그램 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String a = br.readLine();
		String b = br.readLine();
		int answer = solution(a.toCharArray(), b.toCharArray());

		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();

	}

	private static int solution(char[] a, char[] b) {
		int result = 0;
		int lt = 0, rt = 0;
		int len = a.length;

		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (Character ch : b) {
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		while (lt < len && rt < len) {
			if ((rt - lt) == b.length) { // T의 문자열 길이와 슬라이딩윈도우 크기가 같다면
				if (map2.equals(map1) == true) { // 해쉬맵이 같을시 동일하므로 결과값 증가
					result++;
				}
				if (map1.containsKey(a[lt])) { // 슬라이딩 윈도우 해시맵에 키가 존재한다면 -1
					map1.put(a[lt], map1.getOrDefault(a[lt], 0) - 1);
					if (map1.get(a[lt]) == 0) { // 왼쪽 인덱스 제거 후 0이라면 중복값x
						map1.remove(a[lt]); // 해당 왼쪽 인덱스 값 제거
					}
				}
				lt++;
				if (rt == len - 1) { // rt가 마지막 인덱스에 왔을때 처리문
					if (map2.containsKey(a[rt])) {
						map1.put(a[rt], map1.getOrDefault(a[rt], 0) + 1);
					}
					if (map2.equals(map1) == true) {
						result++;
					}
					rt++; // while문 종료
				}
			}
			if ((rt - lt) < b.length) { // 인덱스가 T의 길이만큼이 아니라면 오른쪽 인덱스 값을 해시맵에 추가
				if (map2.containsKey(a[rt])) {
					map1.put(a[rt], map1.getOrDefault(a[rt], 0) + 1);
				}
				rt++;
			}
		}

		return result;
	}
}
