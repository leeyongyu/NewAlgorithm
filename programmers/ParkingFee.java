package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

//초 : 1000 
//분 : (1000 * 60)
//시 : (1000 * 60 * 60)
public class ParkingFee {

	public static void main(String[] args) {
		// 주차 요금 계산

	}

	class Solution {
		public int[] solution(int[] fees, String[] records) throws ParseException {
			int[] answer = {};
			HashMap<String, String> timeMap = new HashMap<>(); // 차량의 부분 누적 시간
			HashMap<String, Long> resultMap = new HashMap<>(); // 차량의 총 누적 시간
			TreeSet<String> set = new TreeSet<>(); // 순서를 저장할 변수
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm"); // 날짜 포맷 형식 선언
			for (int i = 0; i < records.length; i++) {
				String[] str = records[i].split(" ");
				String time = str[0]; // 입/출차 시각
				String carNum = str[1]; // 차량 번호
				String info = str[2]; // 입차/출차
				if (timeMap.containsKey(carNum) != true && "IN".equals(info) == true) {
					// 입차시 차량번호의 시간 정보 저장
					timeMap.put(carNum, time);
				}
				if (timeMap.containsKey(carNum) == true && "OUT".equals(info) == true) {
					// 출차시 입차시간 정보를 가져와 누적시간을 계산한다.
					String inTime = timeMap.get(carNum); // 입차시간
					Date date1 = formatter.parse(inTime);
					Date date2 = formatter.parse(time); // 출차시간
					long stay = (date2.getTime() - date1.getTime()) / 60000; // 출차시간-입차시간(분)
					if (resultMap.containsKey(carNum) == true) {
						// 총 누적시간이 이미 해시맵에 존재한다면, 이전누적시간 + 현재누적시간 저장
						long beforeTime = resultMap.get(carNum);
						resultMap.put(carNum, beforeTime + stay);
					} else {
						// 총 누적시간이 존재하지 않는다면, 최초 누적 입력
						resultMap.put(carNum, stay);
					}
					set.add(carNum); // 출차시 순서정보 최초 저장, 중복을 허용하지 않음.
					timeMap.remove(carNum); // 입차시간이 저장된 해시맵 KEY를 제거한다.(재입차시를 고려)
				}
			}
			// 입차시간이 저장된 해시맵이 모두 제거되지 않았다면 출차하지 않은 차량이 있는것으로 출차 처리 로직
			if (timeMap.size() > 0) {
				for (String key : timeMap.keySet()) {
					Date date2 = formatter.parse("23:59"); // 출차 시간 = 23:59
					Date date1 = formatter.parse(timeMap.get(key)); // 입차 시간
					long stay = (date2.getTime() - date1.getTime()) / 60000;
					if (resultMap.containsKey(key) == true) {
						long beforeTime = resultMap.get(key);
						resultMap.put(key, beforeTime + stay);
					} else {
						resultMap.put(key, stay);
					}
					set.add(key); // 차량 순서 정보 저장(최초 출차)
				}
			}
			answer = new int[resultMap.size()]; // 출력 배열 사이즈 선언
			int i = 0;
			for (String seq : set) {
				for (String key : resultMap.keySet()) {
					if (seq.equals(key)) { // 순서정보로 반복하여 저장
						long totalTime = resultMap.get(key); // 총 누적 시간
						long time = (totalTime - fees[0]); // 초과 시간 계산
						if (time <= 0) { // 초과시간을 넘지 않았다면 기본 값
							answer[i++] = (int) fees[1];
						} else { // 초과시간을 넘었을시 계산 값
									// 단위시간으로 나눈 값이 0으로 나누어 떨어지지 않는다면 시간+단위시간/단위시간
							time = time % fees[2] != 0 ? (time + fees[2]) / fees[2] : time / fees[2];
							answer[i++] = (int) (fees[1] + (time * fees[3])); // 내야할 요금 계산
						}
					}
				}
			}
			return answer;
		}
	}
}
