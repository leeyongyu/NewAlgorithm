package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OpenChatFailed {

	public static void main(String[] args) {
		// 오픈채팅방(효율성25~32 실패 코드)
	}

	class User {
		String id;
		String name;
		String message;

		User(String id, String name, String message) {
			this.id = id;
			this.name = name;
			this.message = message;
		}

		void set(String name, String message) {
			this.name = name;
			this.message = message;
		}
	}

	public String[] solution(String[] record) {
		String[] answer = {};
		String enter = "님이 들어왔습니다.";
		String quit = "님이 나갔습니다.";
		int idxcnt = 0;
		List<User> list = new ArrayList<>(); // 모든 기록 리스트
		// List<String> change = new ArrayList<>(); // Leave와 Change 리스트
		for (int i = 0; i < record.length; i++) {
			StringTokenizer token = new StringTokenizer(record[i], " ");
			idxcnt = token.countTokens();
			String[] str = new String[idxcnt];
			for (int j = 0; j < idxcnt; j++) {
				str[j] = token.nextToken();
			}
			if ("Enter".equals(str[0]) == true) {
				String userId = str[1];
				String name = str[2];
				String message = name + enter;
				if (list.size() > 0) {
					for (int k = 0; k < list.size(); k++) {
						if (userId.equals(list.get(k).id)) {
							String beforename = list.get(k).name;
							String msg = list.get(k).message;
							msg = msg.replace(beforename, name);
							list.get(k).set(name, msg);
						}
					}
				}
				User user = new User(userId, name, message);
				list.add(user);
			} else if ("Leave".equals(str[0]) == true) {
				String name = "";
				for (int k = 0; k < list.size(); k++) {
					if (str[1].equals(list.get(k).id)) {
						name = list.get(k).name;
					}
				}
				// change.add(str[0] + " " + str[1]);
				String userId = str[1];
				String message = name + quit;
				User user = new User(userId, name, message);
				list.add(user);
			}
			if (list.size() > 0 && "Change".equals(str[0])) {
				// change.add(str[0] + " " + str[1] + " " + str[2]);
				for (int k = 0; k < list.size(); k++) {
					if (str[1].equals(list.get(k).id)) {
						String newname = str[2];
						String msg = list.get(k).message;
						String name = list.get(k).name;
						msg = msg.replace(name, newname);
						list.get(k).set(newname, msg);
					}
				}
			}
		}
		answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).message;
		}
		return answer;
	}
}
