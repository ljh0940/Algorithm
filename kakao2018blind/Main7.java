package kakao2018blind;

import java.util.ArrayList;
import java.util.HashMap;

class Main7 {
	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		sol.solution(msg);
	}
}

class Solution7 {
	HashMap<String, Integer> hash;
	ArrayList<Integer> arr;
	int max = 27;

	public int[] solution(String msg) {
		int[] answer = { 0 };

		hash = new HashMap<>();
		arr = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			char alpha = (char) ('A' + i);
			hash.put(Character.toString(alpha), i + 1);
		}

		for (int i = 0; i < msg.length(); i++) {
			String ori = Character.toString(msg.charAt(i));
			int temp = i;
			int temp2 = 0;

			while (true) {
				if (hash.containsKey(ori) == false) {
					arr.add(hash.get(ori.substring(0, ori.length() - 1)));
					hash.put(ori, max);
					max++;
					i = i + temp2 - 1;
					break;
				}

				if (msg.length() - 1 == temp) {
					arr.add(hash.get(ori));
					answer = new int[arr.size()];
					for (int j = 0; j < answer.length; j++) {
						answer[j] = arr.get(j);
					}

					return answer;
				}

				ori = ori + Character.toString(msg.charAt(++temp));
				temp2++;
				if (msg.length() == temp) {
					arr.add(hash.get(ori));

					answer = new int[arr.size()];
					for (int j = 0; j < answer.length; j++) {
						answer[j] = arr.get(j);
					}

					return answer;
				}
			}
		}
		answer[0] = hash.get(msg);

		return answer;

	}
}