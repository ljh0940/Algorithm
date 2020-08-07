package boj2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<Integer, Integer> hash = new HashMap<>();
		HashMap<Integer, Integer> hash2 = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int index = 0;
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (hash.containsKey(value))
				hash.put(value, hash.get(value) + 1);
			else {
				hash.put(value, 1);
				arr.add(value);
			}

			if (!hash2.containsKey(value)) {
				hash2.put(value, index);
				index++;
			}
		}

		Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (hash.get(o1) < hash.get(o2)) {
					return 1;
				} else if (hash.get(o1) == hash.get(o2)) {
					if (hash2.get(o1) > hash2.get(o2)) {
						return 1;
					}
				}

				return -1;
			}
		};

		arr.sort(com);

		StringBuilder sb = new StringBuilder();
		for (int num : arr) {
			for (int i = 0; i < hash.get(num); i++)
				sb.append(num).append(" ");
		}

		System.out.println(sb.toString());
	}
}