package aq.koptev.other.binaryTree;

public class Node {
	private int intData;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int intData) {
		super();
		this.intData = intData;
	}
	public Node getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}
	public Node getRightChild() {
		return rightChild;
	}
	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	public int getIntData() {
		return intData;
	}
	@Override
	public String toString() {
		return "" + intData;
	}
}
