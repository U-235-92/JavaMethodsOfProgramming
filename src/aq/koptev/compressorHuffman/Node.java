package aq.koptev.compressorHuffman;

public class Node implements Comparable<Node>{

	private int frequensy;
	private String value;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int frequensy, String value) {
		this.frequensy = frequensy;
		this.value = value;
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

	public int getFrequensy() {
		return frequensy;
	}

	public String getValue() {
		return value;
	}

	@Override
	public int compareTo(Node o) {
		return frequensy - o.frequensy;
	}
	
	@Override
	public String toString() {
		return value + "=" + frequensy;
	}
}
