package boj1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input[] = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		HashMap<String, String> numToNameHash = new HashMap<>();
		HashMap<String, String> nameToNumHash = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String pocketmonName = br.readLine();

			numToNameHash.put(Integer.toString(i), pocketmonName);
			nameToNumHash.put(pocketmonName, Integer.toString(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String question = br.readLine();

			if (numToNameHash.containsKey(question))
				sb.append(numToNameHash.get(question));
			else
				sb.append(nameToNumHash.get(question));
			if (i != m - 1)
				sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}