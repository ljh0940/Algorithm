package kakao2018blind;

import java.util.Comparator;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		int cacheSize = 5;
//		String[] cities = { "Jeju", "Pangyo", "NewYork", "newyork" };
//		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
				"Jeju", "NewYork", "Rome" };
		sol.solution(cacheSize, cities);
	}

}

class Node {
	String city;
	int time;

	Node(String city, int time) {
		this.city = city;
		this.time = time;
	}
}

class Solution5 {
	int time = 0;
	int count = 0;

	LinkedList<Node> arr;

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		if (cacheSize == 0)
			return cities.length * 5;

		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toLowerCase();
		}

		arr = new LinkedList<>();

		Comparator<Node> com = new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.time > o2.time)
					return 1;
				else
					return -1;
			}
		};

		arr.sort(com);

		for (int i = 0; i < cities.length; i++) {
			int index = check(cities[i]);
			if (index != -1) {
				arr.get(index).time = count;
				time++;
				arr.sort(com);
			} else {
				if (arr.size() > cacheSize - 1)
					arr.removeFirst();
				arr.add(new Node(cities[i], count));
				time = time + 5;
			}
			count++;
		}

		answer = time;

		return answer;
	}

	int check(String str) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).city.equals(str) == true)
				return i;
		}

		return -1;
	}
}