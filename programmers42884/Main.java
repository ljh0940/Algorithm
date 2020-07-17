package programmers42884;

import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int routes[][] = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
//		int routes[][] = { { 0, 1 }, { 1, 2 }, { 2, 4 } };
		sol.solution(routes);
	}
}

class Car {
	int start;
	int end;

	Car(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

class Solution {
	PriorityQueue<Car> pq;

	public int solution(int[][] routes) {
		int answer = 1;

		pq = new PriorityQueue<Car>(new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				if (o1.start > o2.start)
					return 1;
				else if (o1.start == o2.start) {
					if (o1.end > o2.end)
						return 1;
					else
						return -1;
				} else
					return -1;
			}
		});

		for (int i = 0; i < routes.length; i++) {
			pq.offer(new Car(routes[i][0], routes[i][1]));
		}

		Car car = pq.poll();
		int start = car.start;
		int end = car.end;

		while (!pq.isEmpty()) {
			car = pq.poll();
			boolean flag = false;

			if (start <= car.start && car.start <= end) {
				start = car.start;
				flag = true;
			}
			if (start <= car.start && car.end <= end) {
				end = car.end;
				flag = true;
			}

			if (flag == false) {
				start = car.start;
				end = car.end;
				answer++;
			}

		}

		return answer;
	}
}