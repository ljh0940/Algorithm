package kakao2018blind;

import java.util.ArrayList;
import java.util.Collections;

class Main11 {
	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		sol.solution(N, stages);
	}

}

class Stage implements Comparable<Stage> {
	int stageNum;
	int total;
	int clear;
	float fail;

	Stage(int stageNum) {
		this.stageNum = stageNum;
	}

	void calc() {
		fail = total == 0 ? 0 : (float) (total - clear) / (float) total;
	}

	@Override
	public int compareTo(Stage o) {
		if (this.fail < o.fail)
			return 1;
		else if (this.fail == o.fail) {
			return this.stageNum - o.stageNum;
		}
		return -1;
	}
}

class Solution11 {
	ArrayList<Stage> stageList;

	public int[] solution(int N, int[] stages) {
		int[] answer = {};
		stageList = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			stageList.add(new Stage(i));
		}

		for (int i = 0; i < stages.length; i++) {
			for (int j = 0; j <= stages[i]; j++) {
				if (j == 0)
					continue;
				if (j == N + 1)
					break;
				Stage stage = stageList.get(j);

				if (j < stages[i])
					stage.clear++;
				stage.total++;
			}
		}

		for (int i = 0; i < stageList.size(); i++) {
			stageList.get(i).calc();
		}

		Collections.sort(stageList);
		answer = new int[stageList.size() - 1];

		for (int i = 0; i < stageList.size(); i++) {
			if (stageList.get(i).stageNum == 0) {
				stageList.remove(i);
				if (i == stageList.size())
					break;
			}
			answer[i] = stageList.get(i).stageNum;
		}

		return answer;
	}
}