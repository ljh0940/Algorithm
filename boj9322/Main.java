package boj9322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class PublicKey {
	int index;
	String word;

	PublicKey(int index) {
		this.index = index;
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<String, Integer> firstPublicKeys;
		ArrayList<PublicKey> arr;

		int t = Integer.parseInt(st.nextToken());
		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			arr = new ArrayList<>();
			firstPublicKeys = new HashMap<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String word = st.nextToken();
				firstPublicKeys.put(word, i);
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String word = st.nextToken();
				int index = firstPublicKeys.get(word);
				arr.add(new PublicKey(index));
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr.get(i).word = st.nextToken();
			}

			arr.sort(new Comparator<PublicKey>() {

				@Override
				public int compare(PublicKey o1, PublicKey o2) {
					if (o1.index > o2.index)
						return 1;
					else
						return -1;
				}
			});

			StringBuilder sb = new StringBuilder();
			for (PublicKey key : arr) {
				sb.append(key.word).append(" ");
			}

			System.out.println(sb.toString());
		}
	}
}