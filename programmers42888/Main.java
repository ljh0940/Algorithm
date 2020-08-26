package programmers42888;

import java.util.ArrayList;
import java.util.HashMap;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String record[] = {};
		sol.solution(record);
	}
}

class Message {
	String uid;
	String command;

	public Message(String uid, String command) {
		this.uid = uid;
		this.command = command;
	}
}

class Solution {
	ArrayList<Message> messageList;
	HashMap<String, String> hashMap;

	public String[] solution(String[] record) {
		String[] answer;

		hashMap = new HashMap<>();
		messageList = new ArrayList<>();

		for (String line : record) {
			String lineArray[] = line.split(" ");

			String command = lineArray[0];
			String uid = lineArray[1];
			String nickName;
			if (lineArray.length == 3) {
				nickName = lineArray[2];
				hashMap.put(uid, nickName);
			}

			if (command.equals("Change"))
				continue;

			messageList.add(new Message(uid, command));
		}

		answer = new String[messageList.size()];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < messageList.size(); i++) {
			Message message = messageList.get(i);
			sb.append(hashMap.get(message.uid));
			sb.append("님이 ");

			if (message.command.equals("Enter")) {
				sb.append("들어왔습니다.");
			} else if (message.command.equals("Leave")) {
				sb.append("나갔습니다.");
			}
			answer[i] = sb.toString();
			sb.setLength(0);
		}

		return answer;
	}
}