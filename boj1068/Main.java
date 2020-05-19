package boj1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Node tree = new Node(null, -1);

		for (int i = 0; i < n; i++) {
			tree.createNode(-1, i);
		}
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			Node node = tree.findIndex(tree, i);
			node.parent = tree.findIndex(tree, number);
			if (number != -1) {
				node.parent.nodeArr.add(node);
				for (int j = 0; j < tree.nodeArr.size(); j++) {
					if (tree.nodeArr.get(j).index == node.index) {
						tree.nodeArr.remove(j);
						break;
					}
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int deleteIndex = Integer.parseInt(st.nextToken());

		tree.delete(deleteIndex);

		System.out.println(tree.calcLeaf(tree));
	}
}

class Node {
	ArrayList<Node> nodeArr = new ArrayList<>();
	Node parent = null;

	int index;

	Node(Node parent, int index) {
		this.parent = parent;
		this.index = index;
	}

	void createNode(int parentIndex, int index) {
		Node node = findIndex(this, parentIndex);

		node.nodeArr.add(new Node(node, index));
	}

	Node findIndex(Node node, int index) {
		if (node == null)
			return null;
		if (node.index == index)
			return node;
		else {
			if (node.nodeArr == null)
				return null;

			for (int i = 0; i < node.nodeArr.size(); i++) {
				Node findNode = findIndex(node.nodeArr.get(i), index);
				if (findNode != null)
					return findNode;
			}
		}

		return null;
	}

	void delete(int index) {
		Node node = findIndex(this, index);
		if (node.parent == null) {
			nodeArr.clear();
			return;
		}
		for (int i = 0; i < node.parent.nodeArr.size(); i++) {
			if (node.parent.nodeArr.get(i).index == index) {
				node.parent.nodeArr.remove(i);
				return;
			}
		}
	}

	int calcLeaf(Node node) {
		if (node.nodeArr.size() == 0) {
			if (node.index == -1)
				return 0;
			else
				return 1;
		}

		int count = 0;
		for (int i = 0; i < node.nodeArr.size(); i++) {
			count = count + node.calcLeaf(node.nodeArr.get(i));
		}

		return count;
	}

}