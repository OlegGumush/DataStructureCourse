package DataStructure;

public class Ex10 {
	class BinarySearchTree {
		private class BSTNode {
			Object data;
			BSTNode left,right;
			
			public BSTNode(Object data,BSTNode left,BSTNode right) {
				this.data = data;
				this.left = left;
				this.right = right;
			}
			
			@Override
			public String toString() {
				return this.data.toString();
			}
		}

		private BSTNode root;
		
		public BinarySearchTree(){
			root = null;
		}
		
		public void insert(Object data) {
			root = insert(root,data);
		}

		private BSTNode insert(BSTNode bstNode, Object data) {
			if(bstNode == null) return new BSTNode(data, null, null);
			if(compare(data,bstNode.data) < 0) 
				bstNode.left = insert(bstNode.left, data);
			else
				bstNode.right = insert(bstNode.right, data);
			return bstNode;
		}

		private int compare(Object d1, Object d2) {
			if((Integer)d1 > (Integer)d2) return 1;
			if((Integer)d1 < (Integer)d2) return -1;
			return 0;
		}
		
		public boolean find(Object data) {
			return find(root,data);
		}
		
		private boolean find(BSTNode bstNode, Object data) {
			if(bstNode == null) return false;
			if(compare(bstNode,data) == 0) return true;
			if(compare(bstNode,data) < 0) return find(bstNode.left, data);
			else return find(bstNode.right, data);
		}

		public void remove(Object data) {
			root = remove(root,data);
		}
		
		private BSTNode remove(BSTNode bstNode, Object data) {
			if(bstNode == null) return null;
			if(compare(data,bstNode.data) < 0)
				bstNode.left = remove(bstNode.left,data);
			else if(compare(data,bstNode.data) > 0)
				bstNode.right = remove(bstNode.right,data);
			else {
				if(bstNode.left == null && bstNode.right == null) bstNode = null;
				else if(bstNode.left != null && bstNode.right == null) bstNode = bstNode.left;
				else if(bstNode.left == null && bstNode.right != null) bstNode = bstNode.right;
				else {
					if(bstNode.right.left == null) {
						bstNode.right.left = bstNode.left;
						bstNode = bstNode.right;
					}
					else {
						BSTNode m , n = bstNode.right;
						while(n.left.left != null) n = n.left;
						m = n.left;
						n.left = m.right;
						bstNode.data = m.data;
					}
				}
			}
			return bstNode;
		}
		
		public boolean isEmpty() {
			return root == null;
		}
		
		/**
		 * Q1 - number of nodes in the tree 
		 * Complexity: O(n)
		 */
		public int size(){
			return size(root);
		}
		
		private int size(BSTNode node) {
			if(node == null)
				return 0;
			return 1 + size(node.left) + size(node.right);
		}

		/**
		 * Q2 - number of childs for node with the value data  
		 * Complexity: O(log n)
		 */
		public int numOfChilds(Object data){
			BSTNode n = root;
			while(n!=null && !n.data.equals(data)) {
				if(compare(n.data, data) > 0) n = n.left;
				else n = n.right;
			}
			if(n == null) return 0;
			int child = 0;
			if(n.left != null) child++;
			if(n.right != null) child++;
			return child;
		}

		/**
		 * Q3 - to String
		 * Complexity: O(n)
		 */
		@Override
		public String toString() {
			String[] ans = new String[1];
			ans[0] = "";
			toString(root,ans);
			return ans[0];
		}

		private void toString(BSTNode node, String[] ans) {
			if(node != null) {
				toString(node.left,ans);
				ans[0] = ans[0] + node.data + ", ";
				toString(node.right,ans);
			}
		}
		
		public int numOfLeaves(){
			return numOfLeaves(root);
		}
		
		/**
		 * Q4 - number of leaves
		 * Complexity: O(n)
		 */
		private int numOfLeaves(BSTNode node) {
			if(node == null) return 0;
			if(node.left == null && node.right == null) return 1 + numOfLeaves(node.left) + numOfLeaves(node.right);
			return numOfLeaves(node.left) + numOfLeaves(node.right);
		}

		/**
		 * Q5 - number of nodes with at least one child
		 * Complexity: O(n)
		 */
		public int numOfParents (){
			return size() - numOfLeaves();
		}
		
		/**
		 * Q6 - copy constructor
		 * Complexity: O(n)
		 */
		public BinarySearchTree(BinarySearchTree bst) {
			this.root = clone(bst.root);
		}

		private BSTNode clone(BSTNode bstNode) {
			if(bstNode == null) return null;
			return new BSTNode(bstNode.data, clone(bstNode.left), clone(bstNode.right));
		}
	}
}