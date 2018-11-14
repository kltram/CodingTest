import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ramesh
 * 
 *         description InOrder traversal: To traverse a binary tree in Inorder,
 * 
 *         1. Traverse the Left subtree. 2. Visit the root node and print data
 *         of that node. 3. Traverse the Right subtree.
 * 
 */
public class InOrderBinaryTreeTraversal {
	private Node rootNode;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of node size :");
		int length = sc.nextInt();
		String[] nodes = new String[length];

		System.out.println("Please enter node array elements value");
		for (int i = 0; i < length; i++) {
			String userInput = sc.next();
			nodes[i] = userInput;
		}
		System.out.println("The Node array input values from user is : "); 
		System.out.println(Arrays.toString(nodes));

		// TODO Auto-generated method stub
		new InOrderBinaryTreeTraversal(nodes);
	}

	public InOrderBinaryTreeTraversal(String[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			if (!nodes[i].equals("null"))
			addNode(rootNode, Integer.parseInt(nodes[i]));
		}

		System.out.println("\n--------------------------------");
		System.out.println("\nIn Order Traversal Binary Tree Output: ");
		System.out.println("\n--------------------------------");
		printTreeInOrder(rootNode);
		System.out.println("\n--------------------------------");
		System.out.println("\n---------Coded By Ramesh-------");
	}

	// Adds the node to graph
	private void addNode(Node rootNode, int data) {
		if (rootNode == null) {
			Node temp = new Node(data);
			this.rootNode = temp;
		} else {
			addNodeInProperPlace(rootNode, data);
		}
	}

	// Add the Nodes to proper places in graph
	private void addNodeInProperPlace(Node rootNode, int nodeVal) {
		if (nodeVal > rootNode.getData()) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), nodeVal);
			} else {
				Node temp1 = new Node(nodeVal);
				rootNode.setRight(temp1);
			}
		} else if (nodeVal < rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), nodeVal);
			} else {
				Node temp1 = new Node(nodeVal);
				rootNode.setLeft(temp1);
			}
		}
	}

	// Traversal tree in In-order Printing.
	private void printTreeInOrder(Node rootNode) {
		if (rootNode == null)
			return;
		printTreeInOrder(rootNode.getLeft());
		System.out.print(rootNode.getData() + " ");
		printTreeInOrder(rootNode.getRight());
	}

	public class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		/**
		 * @return the data
		 */
		public int getData() {
			return data;
		}

		/**
		 * @param data
		 *            the data to set
		 */
		public void setData(int data) {
			this.data = data;
		}

		/**
		 * @return the left
		 */
		public Node getLeft() {
			return left;
		}

		/**
		 * @param left
		 *            the left to set
		 */
		public void setLeft(Node left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public Node getRight() {
			return right;
		}

		/**
		 * @param right
		 *            the right to set
		 */
		public void setRight(Node right) {
			this.right = right;
		}

	}

}
