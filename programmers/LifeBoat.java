package programmers;

import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {
		// 구명보트

	}

	class Solution {
		public int solution(int[] people, int limit) {
			int answer = 0;
			int len = people.length;
			Arrays.sort(people); // 오름차순 정렬
			int lt = 0, rt = len - 1; // 왼쪽 포인터 = 최소값, 오른쪽 포인터 = 최대값
			int sum = 0;
			while (lt <= rt) {
				// sum > limit라면 lt==rt가 될수있고, sum<=limit라면 lt>rt의 경우가 생기므로 조건설정
				sum = people[lt] + people[rt];
				if (sum > limit) { // 무게제한을 초과한다면
					answer++;
					rt--; // 오른쪽 포인터만 증가
				}
				if (sum <= limit) { // 무게제한을 맞췄다면
					lt++; // 왼쪽 포인터 증가 = 다음 최소값
					rt--; // 오른쪽 포인터 감소 = 다음 최대값
					answer++;
				}
			}
			return answer;
		}
	}

}
