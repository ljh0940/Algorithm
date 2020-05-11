package boj2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

class Main {
	static int count;

	static ArrayList<String> arr;
	static HashSet<String> hash;
	static StringBuilder sb;

	static boolean checked[];

	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		arr = new ArrayList<>();
		sb = new StringBuilder();
		hash = new HashSet<>();
		checked = new boolean[count];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				count++;
			}
		}

		checked = new boolean[count];

		for (int i = 1; i <= count; i++) {
			Arrays.fill(checked, false);
			combination(0, i, 0);
		}

		Iterator<String> iter = hash.iterator();
		while (iter.hasNext()) {
			arr.add(iter.next());
		}

		arr.sort(null);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	static void combination(int index, int depth, int cnt) {
		if (depth == cnt) {
			hash.add(delete(str));
			return;
		}

		for (int i = index; i < count; i++) {
			checked[i] = true;
			combination(i + 1, depth, cnt + 1);
			checked[i] = false;
		}
	}

	static String delete(String string) {
		int cnt = -1;
		StringBuilder sb2 = new StringBuilder();
		Stack<Boolean> st = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '(') {
				cnt++;
				st.push(checked[cnt]);
				if (checked[cnt] == true) {
					continue;
				}
			}
			if (c == ')') {
				if (st.pop() == true)
					continue;
			}
			sb2.append(c);
		}

		return sb2.toString();
	}
}