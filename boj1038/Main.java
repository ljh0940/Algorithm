package boj1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	static int n;
	static boolean checked[];
	static ArrayList<Long> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			checked = new boolean[10];
			combination(0, i, 0);
			if (arr.size() > n) {
				arr.sort(null);
				System.out.println(arr.get(n));
				return;
			}
			n = n - arr.size();
			arr.clear();
		}

		System.out.println(-1);

	}

	static void combination(int index, int depth, int count) {
		if (depth == count) {
			String str = "";
			for (int i = 9; i >= 0; i--) {
				if (checked[i] == true)
					str = str + i;
			}

			arr.add(Long.parseLong(str));
			return;
		}

		for (int i = index; i < 10; i++) {
			checked[i] = true;
			combination(i + 1, depth, count + 1);
			checked[i] = false;
		}
	}
}