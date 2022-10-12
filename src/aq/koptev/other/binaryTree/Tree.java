package aq.koptev.other.binaryTree;

public class Tree {

	private Node root;
	
	public Tree() {}
	
	public Tree(Node node) {
		root = node;
	}
	
	public void add(Node node) {
		if(root == null) {
			root = node;
		} else {
			Node current = root;
			Node parent = null;
			while(true) {
				parent = current;
				if(node.getIntData() > current.getIntData()) {
					current = current.getRightChild();
					if(current == null) {
						parent.setRightChild(node);
						return;
					}
				} else {
					current = current.getLeftChild();
					if(current == null) {
						parent.setLeftChild(node);
						return;
					}
				}
			}
		}
	}
	
	public Node remove(int val) {
		return null;
	}
	
	public Node get(int val) {
		Node current = root;
		while(current != null) {
			if(current.getIntData() == val) {
				return current;
			} else if(val > current.getIntData()) {
				current = current.getRightChild();
			} else {
				current =  current.getLeftChild();
			}
		}
		return null;
	}
	
	public Node min() {
		Node min = null;
		Node current = root;
		while(current != null) {
			min = current;
			current = current.getLeftChild();
		}
		return min;
	}
	
	public Node max() {
		Node max = null;
		Node current = root;
		while(current != null) {
			max = current;
			current = current.getRightChild();
		}
		return max;
	}
	
	public void travel() {
		travel0(root);
	}
	
	private void travel0(Node node) {
		if(node != null) {
			travel0(node.getLeftChild());
			System.out.println(node);
			travel0(node.getRightChild());
		}
	}
}
