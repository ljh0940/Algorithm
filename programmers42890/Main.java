package programmers42890;

import java.util.ArrayList;
import java.util.HashSet;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String relation[][] = { { "b", "2", "a", "a", "b" }, { "b", "2", "7", "1", "b" }, { "1", "0", "a", "a", "8" },
				{ "7", "5", "a", "a", "9" }, { "3", "0", "a", "f", "9" } };
		sol.solution(relation);
	}
}

class Solution {
	int answer = 0;
	ArrayList<String> arr;
	ArrayList<Integer> combList;

	public int solution(String[][] relation) {
		arr = new ArrayList<>();
		combList = new ArrayList<>();

		combination(relation, 0, 0, relation.length, new boolean[relation[0].length]);
		
		combList.sort(null);

		for (int i = 0; i < combList.size(); i++) {
			for (int j = i + 1; j < combList.size(); j++) {
				if ((combList.get(i) & combList.get(j)) == combList.get(i)) {
					combList.remove(j);
					j--;
				}
			}
		}

		return combList.size();
	}

	void combination(String relation[][], int index, int count, int depth, boolean checked[]) {
		if (count == depth) {
			return;
		}

		for (int i = index; i < relation[0].length; i++) {
			checked[i] = true;
			if (isUnique(relation, checked)) {
				int check = 0;
				for (int j = 0; j < checked.length; j++) {
					if (checked[j])
						check += (1 << j);
				}

				combList.add(check);
			} else {
				combination(relation, i + 1, count + 1, depth, checked);
			}
			checked[i] = false;
		}

	}

	boolean isUnique(String[][] relation, boolean checked[]) {
		HashSet<String> hashSet = new HashSet<>();

		for (int i = 0; i < relation.length; i++) {
			String string = "";
			for (int j = 0; j < relation[i].length; j++) {
				if (checked[j])
					string = string + relation[i][j];
			}

			if (hashSet.contains(string))
				return false;
			else
				hashSet.add(string);
		}

		return true;
	}

}