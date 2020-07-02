package programmers42892;

import java.util.ArrayList;
import java.util.Comparator;

class Main {
	public static void main(String[] args) {	
		Solution sol = new Solution();
		int nodeinfo[][] = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		System.out.println(sol.solution(nodeinfo));
	}
}

class Node {
	Node left;
	Node right;
	int number;
	int x;
	int y;

	Node(int number, int x, int y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}

	void insert(int number, int x, int y) {
		if (this.x > x) {
			if (left == null)
				left = new Node(number, x, y);
			else
				left.insert(number, x, y);
		} else {
			if (right == null)
				right = new Node(number, x, y);
			else
				right.insert(number, x, y);
		}
	}

	void preOrder(Node node, ArrayList<Integer> arr) {
		arr.add(node.number);

		if (node.left != null) {
			node.preOrder(node.left, arr);
		}

		if (node.right != null) {
			node.preOrder(node.right, arr);
		}
	}

	void postOrder(Node node, ArrayList<Integer> arr) {
		if (node.left != null)
			node.postOrder(node.left, arr);

		if (node.right != null)
			node.postOrder(node.right, arr);

		arr.add(node.number);
	}

}

class Pos {
	int x;
	int y;
	int number;

	Pos(int x, int y, int number) {
		this.x = x;
		this.y = y;
		this.number = number;
	}
}

class Solution {
	public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];

		ArrayList<Pos> arrayList = new ArrayList<>();

		for (int i = 0; i < nodeinfo.length; i++) {
			arrayList.add(new Pos(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		Comparator<Pos> com = new Comparator<Pos>() {

			@Override
			public int compare(Pos o1, Pos o2) {
				if (o1.y < o2.y)
					return 1;
				else if (o1.y == o2.y) {
					if (o1.x > o2.x)
						return 1;
				}
				return -1;
			}
		};

		arrayList.sort(com);

		Node root = new Node(-1, -1, -1);
		for (int i = 0; i < nodeinfo.length; i++) {
			Pos p = arrayList.get(i);
			root.insert(p.number, p.x, p.y);
		}

		ArrayList<Integer> arr = new ArrayList<>();
		root.preOrder(root.right, arr);
		for (int i = 0; i < arr.size(); i++) {
			answer[0][i] = arr.get(i);
		}
		arr.clear();

		root.postOrder(root.right, arr);
		for (int i = 0; i < arr.size(); i++) {
			answer[1][i] = arr.get(i);
		}

		return answer;
	}
}