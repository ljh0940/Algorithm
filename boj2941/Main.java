package boj2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		int count = 0;
		HashMap<String, Boolean> hash = new HashMap<>();
		hash.put("c=", true);
		hash.put("c-", true);
		hash.put("dz=", true);
		hash.put("d-", true);
		hash.put("lj", true);
		hash.put("nj", true);
		hash.put("s=", true);
		hash.put("z=", true);

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 'a' || word.charAt(i) > 'z')
				continue;

			StringBuilder sb = new StringBuilder();

			sb.append(word.charAt(i));
			if (i != word.length() - 1)
				sb.append(word.charAt(i + 1));

			if (sb.toString().equals("dz")) {
				if (word.length() > i + 2) {
					if (word.charAt(i + 2) == '=') {
						sb.append('=');
						i++;
					}
				}
			}

			if (hash.containsKey(sb.toString()) == true)
				i++;
			count++;
		}

		System.out.println(count);
	}
}