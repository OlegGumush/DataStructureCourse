package DataStructure;

public class Ex09 {
	/**
	 * Q1 - PreOrder , InOrder , PostOrder
	 */
	/**
	 * preorder -  a) DBACFEG , b) FBADCEGIH , c) 3,1,14,5,4,7,16,15,20
	 * inorder  -  a) ABCDEFG , b) ABCDEFGHI , c) 1,3,4,5,7,14,15,16,20
	 * postorder - a) ACBEGFD , b) ACEDBHIGF , c) 1,4,7,5,15,20,16,14,3
	 */

	class MyBinaryTree {
		class BTNode {
			Object data;
			BTNode left,right;
			
			public BTNode(Object data,BTNode left,BTNode right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
			
			@Override
			public String toString() {
				return this.data.toString();
			}
		}

		private BTNode root;
		
		public MyBinaryTree() {
			root = null;
		}
		
		public void insert(Object data) {
			root = insert(root, data);
		}

		private BTNode insert(BTNode node, Object data) {
			if(node == null) 
				return new BTNode(data, null, null);
			double side = Math.random();
			if(side < 0.5) node.left = insert(node.left, data);
			else node.right = insert(node.right, data);
			return node;
		}
		
		/**
		 * Q2 - Print the tree InOrder (left - root - right)
		 * Complexity: O(n)
		 */
		public void printInOrder() {
			printInOrder(root);
		}

		private void printInOrder(BTNode node) {
			if(node !=null) {
				printInOrder(node.left);
				System.out.print(node + ", ");
				printInOrder(node.right);
			}
		}

		/**
		 * Q3 - Print the tree PostOrder (left - right - root)
		 * Complexity: O(n)
		 */
		public void printPostOrder() {
			printPostOrder(root);
		}

		private void printPostOrder(BTNode node) {
			if(node !=null) {
				printPostOrder(node.left);
				printPostOrder(node.right);
				System.out.print(node + ", ");
			}
		}
		
		/**
		 * Q4 - number of nodes in the tree 
		 * Complexity: O(n)
		 */
		public int size(){
			return size(root);
		}
		
		private int size(BTNode node) {
			if(node == null)
				return 0;
			return 1 + size(node.left) + size(node.right);
		}
		
		/**
		 * Q5 - find the data in the tree and return it's node
		 * Complexity: O(n)
		 */
		public BTNode find(Object data){
			return find(root,data);
		}

		private BTNode find(BTNode node, Object data) {
			if(node == null) return null;
			if(node.data.equals(data)) return node;
			BTNode l = find(node.left , data);
			if(l != null) return l;
			BTNode r = find(node.left , data);
			if(r != null) return r;
			return null;
		}
		
		/**
		 * Q6 - find the data in the tree and return String represents the vertex contains this data
		 * Complexity: O(n)
		 */
		public String isLeaf(Object data){
			BTNode n = find(data);
			if(n == null) 
				return "not a vertex";
			if(n.left == null && n.right == null)
				return " a leaf ";
			return " not a leaf ";
		}
	}
}