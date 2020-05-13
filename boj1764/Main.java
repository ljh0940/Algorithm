package boj1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<String> hash = new HashSet<>();
		ArrayList<String> arr = new ArrayList<>();

		String str[] = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		for (int i = 0; i < n; i++) {
			hash.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			String string = br.readLine();
			if (hash.contains(string) == true) {
				arr.add(string);
			}
		}

		arr.sort(null);
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append("\n");
		}

		System.out.println(arr.size());
		System.out.print(sb.toString());
	}
}
