package boj7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
	int weight;
	int height;
	int rank = 1;

	Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}

class Main {
	static ArrayList<Person> arr = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int weight = 0;
		int height = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			weight = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			arr.add(new Person(weight, height));
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				int count = 0;
				if (arr.get(i).height < arr.get(j).height) {
					count++;
				}
				if (arr.get(i).weight < arr.get(j).weight) {
					count++;
				}
				if (count == 2)
					arr.get(i).rank++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(arr.get(i).rank).append(" ");

		System.out.println(sb);
	}

}