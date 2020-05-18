package boj1141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

class Main {
	static int n;
	static ArrayList<String> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(br.readLine());
		}

		Comparator<String> com = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length())
					return 1;
				else
					return -1;
			}
		};

		arr.sort(com);

		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (check(i, j) == false) {
					arr.remove(i);
					i--;
					break;
				}
			}
		}

		System.out.println(arr.size());
	}

	static boolean check(int index1, int index2) {
		for (int i = 0; i < arr.get(index1).length(); i++) {
			if (arr.get(index1).charAt(i) != arr.get(index2).charAt(i)) {
				return true;
			}

		}

		return false;
	}
}