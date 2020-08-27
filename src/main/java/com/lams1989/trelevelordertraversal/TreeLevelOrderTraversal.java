package com.lams1989.trelevelordertraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class TreeLevelOrderTraversal {

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		
	}
	
	public static void levelOrder(Node root) {

		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		// Add root to the queue
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(node.data + " ");
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

	}

}
