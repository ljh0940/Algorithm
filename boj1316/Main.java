package boj1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int count = n;
		for (int k = 0; k < n; k++) {
			HashMap<Character, Boolean> hash = new HashMap<>();
			String str = br.readLine();

			char temp = '.';
			for (int i = 0; i < str.length(); i++) {
				if (i != 0 && temp != str.charAt(i)) {
					hash.replace(temp, true);
				}
				if (hash.containsKey(str.charAt(i)) == true) {
					if (hash.get(str.charAt(i)) == true) {
						count--;
						break;
					}
				} else {
					hash.put(str.charAt(i), false);
				}
				temp = str.charAt(i);
			}
		}

		System.out.println(count);
	}
}