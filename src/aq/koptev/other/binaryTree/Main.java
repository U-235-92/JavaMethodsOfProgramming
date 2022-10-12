package aq.koptev.other.binaryTree;

public class Main {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(new Node(10));
		tree.add(new Node(11));
		tree.add(new Node(5));
		tree.add(new Node(5));
		tree.add(new Node(7));
		tree.add(new Node(9));
		tree.travel();
		System.out.println(tree.min());
	}
}
