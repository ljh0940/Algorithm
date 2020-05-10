package boj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static char arr[];
	static boolean checked[];

	static int l;
	static int c;

	static StringBuilder sb;
	static StringBuilder sb2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		sb2 = new StringBuilder();

		arr = new char[c];
		checked = new boolean[c];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);

		dfs(0, 0, 0, 0);

		System.out.print(sb.toString());

	}

	static void dfs(int index, int depth, int m, int j) {
		if (depth == l) {
			if (m >= 1 && j >= 2) {
				sb.append(sb2.toString()).append("\n");
			}
			return;
		}

		for (int i = index; i < c; i++) {
			if (checked[i] == true)
				continue;
			checked[i] = true;
			sb2.append(arr[i]);

			boolean mo = isM(arr[i]);
			int nm = m;
			int nj = j;
			if (mo == true)
				nm++;
			else
				nj++;

			dfs(i, depth + 1, nm, nj);
			sb2.deleteCharAt(sb2.length() - 1);
			checked[i] = false;
		}
	}

	static boolean isM(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
		else
			return false;
	}
}