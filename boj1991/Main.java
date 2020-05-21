package boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Node tree = new Node('A');

		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			char value = str[0].charAt(0);
			char left = str[1].charAt(0);
			char right = str[2].charAt(0);

			tree.add(value, left, right);
		}

		StringBuilder sb = new StringBuilder();
		tree.preOrder(tree, sb);
		sb.append("\n");
		tree.inOrder(tree, sb);
		sb.append("\n");
		tree.postOrder(tree, sb);
		sb.append("\n");

		System.out.print(sb.toString());
	}
}

class Node {
	Node left = null;
	Node right = null;

	char value;

	Node(char value) {
		this.value = value;
	}

	void add(char value, char left, char right) {
		Node node = findNode(this, value);
		if (left != '.')
			node.left = new Node(left);
		if (right != '.')
			node.right = new Node(right);
	}

	Node findNode(Node node, char value) {
		if (value == node.value)
			return node;

		Node tempNode = null;

		if (node.left != null) {
			tempNode = findNode(node.left, value);
			if (tempNode != null)
				if (tempNode.value == value)
					return tempNode;
		}

		if (node.right != null) {
			tempNode = findNode(node.right, value);
			if (tempNode != null)
				if (tempNode.value == value)
					return tempNode;
		}

		return tempNode;
	}

	void preOrder(Node node, StringBuilder sb) {
		sb.append(node.value);
		if (node.left != null)
			preOrder(node.left, sb);
		if (node.right != null)
			preOrder(node.right, sb);
	}

	void inOrder(Node node, StringBuilder sb) {
		if (node.left != null)
			inOrder(node.left, sb);
		sb.append(node.value);
		if (node.right != null)
			inOrder(node.right, sb);
	}

	void postOrder(Node node, StringBuilder sb) {
		if (node.left != null)
			postOrder(node.left, sb);
		if (node.right != null)
			postOrder(node.right, sb);
		sb.append(node.value);
	}

}