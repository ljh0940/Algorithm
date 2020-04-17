package boj3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashSet<Integer> hash = new HashSet<>();

		int n = 0;
		for (int i = 0; i < 10; i++) {
			n = Integer.parseInt(br.readLine()) % 42;

			if (hash.contains(n) == true)
				continue;

			hash.add(n);
		}

		System.out.println(hash.size());

	}
}