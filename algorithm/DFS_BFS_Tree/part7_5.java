package algorithm;

public class part7_5 {
	Node root;

	public static void main(String[] args) {
		// 이진트리순회(DFS)
		part7_5 tree = new part7_5();

		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		dfs(tree.root);
	}

	private static void dfs(Node root) {
		if (root == null) {
			return;
		}
		// System.out.print(root.data+" "); // 전위순회
		dfs(root.lt);
		// System.out.print(root.data+" "); // 중위순회
		dfs(root.rt);
		// System.out.print(root.data+" "); // 후위순회
	}

}

// 노드 클래스
class Node {
	int data;
	Node lt, rt;

	public Node(int n) {
		data = n;
		lt = rt = null;
	}
}
