package aq.koptev.compressorHuffman;

public class Tree implements Comparable<Tree> {
	
	private Node root;
	
	public Tree() {}
	
	public Tree(Node node) {
		if(root == null) {
			root = node;
		} else {
			add(node);
		}
	}
	
	public void add(Node node1, Node node2) {
		if(node1.getFrequensy() > node2.getFrequensy()) {
			root.setLeftChild(node2);
			root.setRightChild(node1);
		} else {
			root.setLeftChild(node1);
			root.setRightChild(node2);
		}
	}
	
	public void add(Node node) {
		if(root == null) {
			root = node;
		} else {
			Node current = root;
			Node parent = null;
			while(true) {
				parent = current;
				if(node.getFrequensy() > current.getFrequensy()) {
					current = current.getRightChild();
					if(current == null) {
						parent.setRightChild(node);
						break;
					}
				} else {
					current = current.getLeftChild();
					if(current == null) {
						parent.setLeftChild(node);
						break;
					}
				}
			}
		}
	}
	
	public Node get(int freq, String val) {
		Node current = root;
		while(current != null) {
			if(current.getFrequensy() == freq && current.getValue().equals(val)) {
				return current;
			} else {
				if(freq > current.getFrequensy()) {
					current = current.getRightChild();
				} else {
					current = current.getLeftChild();
				}
			}
		}
		return null;
	}

	public void travel() {
		travel0(root);
	}
	
	private void travel0(Node node) {
		if(node != null) {
			if(node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println(node);
			}
			travel0(node.getLeftChild());
			travel0(node.getRightChild());
		}
	}
	
	@Override
	public int compareTo(Tree o) {
		return root.compareTo(o.root);
	}
	
	@Override
	public String toString() {
		return root.toString();
	}

	public Node getRoot() {
		return root;
	}
}
