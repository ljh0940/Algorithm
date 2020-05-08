package kakao2018blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Main13 {
	public static void main(String[] args) {
		Solution13 sol = new Solution13();
//		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
//				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
//				{ "600", "apeach", "music", "2" } };

		String[][] relation = { { "100", "3", "3", }, { "200", "2", "2" }, { "300", "1", "1" } };
		sol.solution(relation);
	}

}

class Solution13 {
	int foreignKey = 0;
	boolean flag = false;
	boolean keys[];
	ArrayList<String> arr = new ArrayList<>();

	public int solution(String[][] relation) {
		int answer = 0;

		keys = new boolean[relation[0].length];

		for (int i = 0; i < relation[0].length; i++) {
			String row[] = new String[relation.length];
			Arrays.fill(row, "");
			for (int j = 1; j <= relation[0].length - i; j++) {
				makeRow(relation, row, i, j, 0, "");
			}
		}

		answer = foreignKey;

		return answer;
	}

	void makeRow(String[][] relation, String row[], int index, int depth, int count, String col) {
		if (depth == count) {
			if (check(row) == true) {
				ArrayList<Character> temp1 = new ArrayList<>();
				for (int i = 0; i < col.length(); i++)
					temp1.add(col.charAt(i));
				for (int i = 0; i < arr.size(); i++) {
					ArrayList<Character> temp2 = new ArrayList<>();
					for (int j = 0; j < arr.get(i).length(); j++)
						temp2.add(arr.get(i).charAt(j));

					if (temp1.containsAll(temp2) == true) {
						return;
					}
				}

				foreignKey++;
				flag = true;
				arr.add(col);
			}

			return;
		}

		for (int i = index; i < relation[0].length; i++) {
			String ori[] = new String[row.length];
			for (int j = 0; j < ori.length; j++) {
				ori[j] = row[j];
				row[j] = row[j] + "_" + i + "_" + relation[j][i];
			}
			makeRow(relation, row, i + 1, depth, count + 1, col + i);
			for (int j = 0; j < ori.length; j++) {
				row[j] = ori[j];
			}
		}
	}

	boolean check(String row[]) {
		HashMap<String, Boolean> hash = new HashMap<>();

		for (int i = 0; i < row.length; i++) {
			if (hash.containsKey(row[i]) == true)
				return false;

			hash.put(row[i], true);
		}

		return true;
	}
}