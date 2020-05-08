package kakao2018blind;

import java.util.ArrayList;
import java.util.Comparator;

class Main8 {
	public static void main(String[] args) {
		Solution8 sol = new Solution8();
		String files[] = { "ABCD01", "abc1" };
		sol.solution(files);
	}
}

class File {
	String fileName;
	String head;
	String lowerHead;
	String number;
	String tail;
	int index;

	File(String fileName, int index) {
		this.fileName = fileName;
		this.index = index;
		split();
	}

	void split() {
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 0; i < fileName.length(); i++) {
			char c = fileName.charAt(i);

			if (c >= '0' && c <= '9') {
				startIndex = i;
				break;
			}
		}

		for (int i = startIndex + 1; i < fileName.length(); i++) {
			char c = fileName.charAt(i);

			if (c < '0' || c > '9') {
				endIndex = i;
				break;
			}
		}

		endIndex = endIndex == 0 ? fileName.length() : endIndex;

		head = fileName.substring(0, startIndex);
		lowerHead = head.toLowerCase();
		number = fileName.substring(startIndex, endIndex);
		tail = fileName.substring(endIndex, fileName.length());

	}

}

class Solution8 {
	ArrayList<File> arr;

	public String[] solution(String[] files) {
		String[] answer = {};

		arr = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			arr.add(new File(files[i], i));
		}

		Comparator<File> com = new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				if (o1.lowerHead.length() > o2.lowerHead.length()) {
					for (int i = 0; i < o2.lowerHead.length(); i++) {
						if (o1.lowerHead.charAt(i) > o2.lowerHead.charAt(i)) {
							return 1;
						} else if (o1.lowerHead.charAt(i) == o2.lowerHead.charAt(i)) {
							continue;
						} else {
							return -1;
						}
					}
					return 1;
				} else if (o1.lowerHead.length() == o2.lowerHead.length()) {
					for (int i = 0; i < o2.lowerHead.length(); i++) {
						if (o1.lowerHead.charAt(i) > o2.lowerHead.charAt(i)) {
							return 1;
						} else if (o1.lowerHead.charAt(i) == o2.lowerHead.charAt(i)) {
							continue;
						} else {
							return -1;
						}
					}

					if (Integer.parseInt(o1.number) > Integer.parseInt(o2.number)) {
						return 1;
					} else if (Integer.parseInt(o1.number) == Integer.parseInt(o2.number)) {
						if (o1.index > o2.index)
							return 1;
						else
							return -1;
					} else {
						return -1;
					}
				} else {
					for (int i = 0; i < o1.lowerHead.length(); i++) {
						if (o1.lowerHead.charAt(i) > o2.lowerHead.charAt(i)) {
							return 1;
						} else if (o1.lowerHead.charAt(i) == o2.lowerHead.charAt(i)) {
							continue;
						} else {
							return -1;
						}
					}
					return -1;
				}
			}
		};

		arr.sort(com);

		answer = new String[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i).fileName;
		}

		return answer;
	}
}