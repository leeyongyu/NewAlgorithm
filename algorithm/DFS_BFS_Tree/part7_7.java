package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class part7_7 {
	Node2 root;

	public static void main(String[] args) {
		// 이진트리순회(BFS)
		part7_7 tree = new part7_7();

		tree.root = new Node2(1);
		tree.root.lt = new Node2(2);
		tree.root.rt = new Node2(3);
		tree.root.lt.lt = new Node2(4);
		tree.root.lt.rt = new Node2(5);
		tree.root.rt.lt = new Node2(6);
		tree.root.rt.rt = new Node2(7);
		bfs(tree.root);
	}

	private static void bfs(Node2 root) {
		if (root == null) {
			return;
		}
		Queue<Node2> queue = new LinkedList<>();
		queue.offer(root);

		while (queue.isEmpty() != true) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Node2 Node2 = queue.poll();
				System.out.print(Node2.data + " ");
				if (Node2.lt != null) {
					queue.offer(Node2.lt);
				}
				if (Node2.rt != null) {
					queue.offer(Node2.rt);
				}
			}
			System.out.println();
		}
	}

}

// 노드 클래스
class Node2 {
	int data;
	Node2 lt, rt;

	public Node2(int n) {
		data = n;
		lt = rt = null;
	}
}
