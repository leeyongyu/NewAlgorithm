package algorithm;

import java.util.*;
import java.io.*;
public class part5_7 {

	public static void main(String[] args) throws IOException {
		// 교육과정 설계
		Scanner input =new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine(); // 필수과목 순서
		String b = br.readLine(); // 수업설계
		
		String answer = solution(a,b);
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}
	private static String solution(String a, String b) {
		String result ="YES"; // 기본값 세팅
		
		// 문자 배열 변환
		char [] a1 = a.toCharArray();
		char [] b1 = b.toCharArray();
		
		Queue<Character> queue = new LinkedList<>();
		for(int i=0; i<b1.length; i++) {
			queue.offer(b1[i]); // 초기 큐 생성
		}
		int idx=0; // 비교할 필수과목 순서 인덱스
		while(queue.isEmpty() != true) {
			if(idx == a1.length) { // 인덱스가 같아지면 모든 과목을 순서대로 찾음.
				break;
			}
			if(a1[idx] == queue.peek()) { // 첫번째 큐값이 같다면
				idx++; // 인덱스 증가
			}
			queue.poll();
		}
		if(idx < a1.length) { // 정상적으로 돌았을때에는 인덱스가 길이와 같아야함.
			result="NO"; // 결과값 NO 리턴
		}
				
		return result;
	}
}
