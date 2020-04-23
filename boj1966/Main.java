package boj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Document {
	int index;
	int priorty;

	Document(int index, int priory) {
		this.index = index;
		this.priorty = priory;
	}
}

class Main {
	static int n;
	static int index;

	static LinkedList<Document> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			index = Integer.parseInt(st.nextToken());

			arr = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr.add(new Document(i, Integer.parseInt(st.nextToken())));
			}

			change();

			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).index == index) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}

	static void change() {
		for (int i = 0; i < arr.size() - 1; i++) {
			Document d1 = arr.get(i);
			for (int j = i + 1; j < arr.size(); j++) {
				Document d2 = arr.get(j);
				if (d1.priorty < d2.priorty) {
					arr.remove(i);
					arr.addLast(d1);
					change();
					return;
				}

			}
		}
	}
}