package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class OpenChatSuccess {

	public static void main(String[] args) {
		// 오픈채팅방(성공,HashMap사용)

	}

	// 유저 정보 클래스 생성
	class User {
		String id; // 아이디
		String name; // 닉네임
		String message; // 메세지
		String what; // Enter, Leave
		// 생성자 클래스 선언

		User(String id, String name, String message, String what) {
			this.id = id;
			this.name = name;
			this.message = message;
			this.what = what;
		}

		// setter 메소드 생성(닉네임,메세지)
		void set(String name, String message) {
			this.name = name;
			this.message = message;
		}
	}

	public String[] solution(String[] record) {
		String[] answer = {};
		String enter = "님이 들어왔습니다.";
		String quit = "님이 나갔습니다.";
		int idxcnt = 0; // 문자열 토큰 숫자 변수
		List<User> list = new ArrayList<>(); // 모든 기록 리스트
		HashMap<String, String> map = new HashMap<>(); // id와 name 저장
		for (int i = 0; i < record.length; i++) {
			// 각 행을 공백을 기준으로 문자열 토큰으로 저장
			StringTokenizer token = new StringTokenizer(record[i], " ");
			idxcnt = token.countTokens();
			String[] str = new String[idxcnt]; // 문자열 배열에 재선언
			for (int j = 0; j < idxcnt; j++) {
				str[j] = token.nextToken();
			}
			// 입장했을 시 유저정보를 User 클래스에 저장
			if ("Enter".equals(str[0]) == true) {
				String userId = str[1];
				String name = str[2];
				String message = name + enter;
				map.put(userId, name); // 유저ID의 네임정보 변경 혹은 생성
				User user = new User(userId, name, message, str[0]);
				list.add(user);
			}
			// 퇴장시 닉네임은 없으므로 아이디와 메세지만 저장.
			else if ("Leave".equals(str[0]) == true) {
				String name = "";
				String userId = str[1];
				String message = name + quit;
				User user = new User(userId, name, message, str[0]);
				list.add(user);
			}
			// 변경 시 유저ID의 네임정보 변경
			else if ("Change".equals(str[0])) {
				map.put(str[1], str[2]);
			}
		}
		// 변경 처리를 위한 for문(효율성 테스트 문제로 저장과 변경을 나누어야 함)
		for (int i = 0; i < list.size(); i++) {
			// 유저클래스 아이디 정보가 해쉬맵의 아이디에 있다면
			if (map.containsKey(list.get(i).id)) {
				// 입장시 저장한 문자열 닉네임 정보 변경
				if ("Enter".equals(list.get(i).what)) {
					String msg = list.get(i).message;
					String beforename = list.get(i).name;
					String newname = map.get(list.get(i).id);
					msg = msg.replace(beforename, newname);
					list.get(i).set(newname, msg);
				}
				// 퇴장시 저장한 문자열에 닉네임 정보 추가
				else if ("Leave".equals(list.get(i).what)) {
					String msg = list.get(i).message;
					String newname = map.get(list.get(i).id);
					msg = newname + msg;
					list.get(i).set(newname, msg);
				}
			}
		}
		answer = new String[list.size()];
		// 문자열 정보 출력
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).message;
		}
		return answer;
	}
}
