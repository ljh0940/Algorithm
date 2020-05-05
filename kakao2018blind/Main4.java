package kakao2018blind;

import java.util.HashMap;
import java.util.Iterator;

class Main4 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		String str1 = "FRANCE";
		String str2 = "french";
		sol.solution(str1, str2);
	}

}

class Solution4 {
	HashMap<String, Integer> hash1;
	HashMap<String, Integer> hash2;

	int sum[] = new int[2];

	int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		hash1 = new HashMap<>();
		hash2 = new HashMap<>();

		makeArr(hash1, str1, 0);
		makeArr(hash2, str2, 1);

		int kyo = makeKyo();
		int hap = sum[0] + sum[1] - kyo;

		if (kyo == 0 && hap == 0)
			return 65536;

		return kyo * 65536 / hap;

	}

	int makeKyo() {
		int num = 0;

		Iterator<String> iter = hash1.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (hash2.containsKey(key) == true) {
				num = num + Math.min(hash1.get(key), hash2.get(key));
			}
		}

		return num;
	}

	void makeArr(HashMap<String, Integer> hash, String str, int num) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) < 'a' || str.charAt(i) > 'z')
				continue;
			if (str.charAt(i + 1) < 'a' || str.charAt(i + 1) > 'z')
				continue;
			if (hash.containsKey(str.substring(i, i + 2)) == true) {
				hash.replace(str.substring(i, i + 2), hash.get(str.substring(i, i + 2)) + 1);
			} else {
				hash.put(str.substring(i, i + 2), 1);
			}

			sum[num]++;
		}
	}
}
