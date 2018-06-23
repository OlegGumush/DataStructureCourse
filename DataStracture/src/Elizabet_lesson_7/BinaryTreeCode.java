package Elizabet_lesson_7;


import java.util.Random;

public class BinaryTreeCode {
	private class BTNode{
		private Object data;
		private BTNode left, right;

		BTNode(Object data, BTNode left, BTNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public String toString(){return ""+data;}
	}// Node

	private static Random generator = new Random(19580427);
	private BTNode root;

	// constructors
	public BinaryTreeCode(){
		root = null;
	}
	public BinaryTreeCode(BTNode n){
		root = n;
	}
	public BinaryTreeCode(Object data){
		root = new BTNode(data, null, null);
	}
	// methods
	public boolean isEmpty(){
		return this.root == null;
	}
	public void add(Object data) {
		root = add(data, root);
	}
	private BTNode add(Object data, BTNode node) {
		if (node != null){
			double select = generator.nextDouble();
			System.out.printf("%5.2f  ",select);
			if (select < 0.5){
				node.left = add(data, node.left);
				return node;
			}
			else{ 
				node.right = add(data, node.right);
				return node;
			}
		}
		else{
			return  new BTNode(data, null, null);
		}
	}

	public boolean contains(Object data){
		return contains(data, root);
	}
	private boolean contains(Object data, BTNode node){
		boolean ans = false;
		if (node==null){
			ans = false;
		}
		else{
			ans = node.data.equals(data) || contains(data, node.left) || contains(data, node.right);
		}
		return ans;
	}      
	// print all tree nodes
	// PreOrder
	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}
	private void printPreOrder(BTNode node) {//PreOrder
		if (node != null) {
			System.out.print(node.data+", ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	public void printPreorderPlus(){
		printPreorderPlus("", root);
	}
	public void printPreorderPlus(String Path, BTNode node){
		if (node != null){
			System.out.println(node.data + ": " + Path);
			printPreorderPlus(Path+"L", node.left);
			printPreorderPlus(Path+"R", node.right);
		}
	}
	// InOrder
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	private void printInOrder(BTNode node) {//PreOrder
		if (node != null) {
			printInOrder(node.left);
			System.out.print(node.data+", ");
			printInOrder(node.right);
		}
	}
	// PostOrder
	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}
	private void printPostOrder(BTNode node) {//PreOrder
		if (node != null) {
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.data+", ");
		}
	}
	public static void main(String[] args) {
		BinaryTreeCode bt = new BinaryTreeCode();
		int i = 0, size = 8;
		Random generator = new Random(19580427);
		while(i<size) {
			Integer num = generator.nextInt(100);
			bt.add(num); 
			i++;
			System.out.println(" "+num);
		}
		System.out.println("by pre-order");
		bt.printPreOrder();
		System.out.println();
		System.out.println("by pre-order-plus");
		bt.printPreorderPlus();
		System.out.println();
		System.out.println("by in-order");
		bt.printInOrder();
		System.out.println("by post-order");
		bt.printPostOrder();
		// deep copy
		BinaryTreeCode bt1 = new BinaryTreeCode(bt);
		bt1.printPostOrder();
		System.out.println(bt1.contains(78));
		System.out.println(bt1.contains(38));
		System.out.println(bt1.contains(5));
		System.out.println(bt1.contains(19));
		System.out.println(bt1.contains(25));
	}

}
/*
 19
 0,02   22
 0,27   0,29   38
 0,23   0,52   65
 0,26   0,44   0,25   78
 0,00   0,52   0,48   79
 0,69   90
 0,77   0,25   5
by pre-order
19, 22, 38, 78, 65, 79, 90, 5, 

by pre-order-plus
19: 
22: L
38: LL
78: LLL
65: LR
79: LRL
90: R
5: RL

by in-order
78, 38, 22, 79, 65, 19, 5, 90, 
by post-order
78, 38, 79, 65, 22, 5, 90, 19, 
 */
