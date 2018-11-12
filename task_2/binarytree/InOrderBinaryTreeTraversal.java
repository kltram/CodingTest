/**
 * @author Ramesh
 * 
 * description
 * InOrder traversal: To traverse a binary tree in Inorder, 
 * 
 *	1. Traverse the Left subtree. 
 *	2. Visit the root node and print data of that node.
 *	3. Traverse the Right subtree. 
 * 
 */
public class InOrderBinaryTreeTraversal {
	private Node rootNode;
	
	private static int[] val = {45,25,75,15,35};
	
	/*
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InOrderBinaryTreeTraversal(val);
	}

	public  InOrderBinaryTreeTraversal(int[] values) {
		for(int i = 0; i<values.length;i++){
			System.out.print("\nIn Order Traversal Binary Tree Input: "+values[i]);
			addNode(rootNode, values[i]);
		}
		
		System.out.println("\n--------------------------------");
		System.out.println("\nIn Order Traversal Binary Tree Output: ");
		System.out.println("\n--------------------------------");
		printTreeInOrder(rootNode);
		System.out.println("\n--------------------------------");
		System.out.println("\n---------Codded By Ramesh-------");
	}

	private void addNode(Node rootNode, int data) {
		if (rootNode == null) {
			Node temp = new Node(data);
			this.rootNode = temp;
		} else {
			addNodeInProperPlace(rootNode, data);
		}
	}

	private void addNodeInProperPlace(Node rootNode, int data) {
		if (data > rootNode.getData()) {
			if (rootNode.getRight() != null) {
				addNode(rootNode.getRight(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setRight(temp1);
			}
		} else if (data < rootNode.getData()) {
			if (rootNode.getLeft() != null) {
				addNode(rootNode.getLeft(), data);
			} else {
				Node temp1 = new Node(data);
				rootNode.setLeft(temp1);
			}
		}
	}
	
	//Inorder Printing.
	 private void printTreeInOrder(Node rootNode){
	  if(rootNode==null)
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
	 * @param data the data to set
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
	 * @param left the left to set
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
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}
	
}

}
