package boj2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int max;
	int min;

	Node(int max, int min) {
		this.max = max;
		this.min = min;
	}

	void copy(Node ori) {
		this.max = ori.max;
		this.min = ori.min;
	}
}

class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = 0;

	static Node node[];
	static Node temp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		node = new Node[3];
		temp = new Node[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int score = Integer.parseInt(st.nextToken());
				if (i == 0) {
					node[j] = new Node(score, score);
					temp[j] = new Node(score, score);
				} else {
					if (j == 0) {
						temp[j].max = Math.max(node[0].max, node[1].max) + score;
						temp[j].min = Math.min(node[0].min, node[1].min) + score;
					}
					if (j == 1) {
						temp[j].max = Math.max(node[0].max, Math.max(node[1].max, node[2].max)) + score;
						temp[j].min = Math.min(node[0].min, Math.min(node[1].min, node[2].min)) + score;
					}
					if (j == 2) {
						temp[j].max = Math.max(node[1].max, node[2].max) + score;
						temp[j].min = Math.min(node[1].min, node[2].min) + score;
					}
				}
			}
			node[0].copy(temp[0]);
			node[1].copy(temp[1]);
			node[2].copy(temp[2]);
		}

		System.out.println(Math.max(node[0].max, Math.max(node[1].max, node[2].max)) + " "
				+ Math.min(node[0].min, Math.min(node[1].min, node[2].min)));

	}

}
